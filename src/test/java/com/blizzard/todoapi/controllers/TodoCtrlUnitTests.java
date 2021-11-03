package com.blizzard.todoapi.controllers;

import com.blizzard.todoapi.models.Todo;
import com.blizzard.todoapi.repository.ITodoRepository;
import com.blizzard.todoapi.services.TodoSvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoCtrl.class)
public class TodoCtrlUnitTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITodoRepository todoRepository;

    @MockBean
    private TodoSvc todoSvc;

    @Autowired
    ObjectMapper objectMapper;

    private List<Todo> list = new ArrayList<>(Arrays.asList(new Todo("first")));

    @Test
    public void testGetTodos() throws Exception {
        String expected = "[{\"id\":null,\"task\":\"first\",\"done\":false}]";

        when(todoSvc.getAllTodos()).thenReturn(list);
        mockMvc.perform(get("/api/v1/todos")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    public void testAddTodo() throws Exception {
        String expected = "[{\"id\":null,\"task\":\"first\",\"done\":false},{\"id\":null,\"task\":\"this is it\",\"done\":false}]";
        Todo tmpTodo = new Todo("this is it");
        list.add(tmpTodo);

        when(todoSvc.saveTodo(any(Todo.class))).thenReturn(list);

        MockHttpServletRequestBuilder request = put("/api/v1/todos")
                .content(objectMapper.writeValueAsString(tmpTodo))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    public void testUpdateTodo() throws Exception {
        Todo todo = new Todo("updated");
        List<Todo> first = new ArrayList<>(Arrays.asList(todo));
        String expected = objectMapper.writeValueAsString(first);

        when(todoSvc.updateTodo(anyString(), any(Todo.class))).thenReturn(first);
        MockHttpServletRequestBuilder request = patch("/api/v1/todos/{id}", "1")
                .content(objectMapper.writeValueAsString(todo))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    public void testDeleteTodo() throws Exception {
        List<Todo> value = new ArrayList<>();
        String expected = objectMapper.writeValueAsString(value);

        when(todoSvc.deleteTodo(anyString())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder request = delete("/api/v1/todos/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }
}
