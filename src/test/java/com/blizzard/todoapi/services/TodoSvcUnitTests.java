package com.blizzard.todoapi.services;

import com.blizzard.todoapi.models.Todo;
import com.blizzard.todoapi.repository.ITodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoSvcUnitTests {
    @Mock
    private ITodoRepository todoRepository;

    @InjectMocks
    private TodoSvc todoSvc;

    @Test
    public void getAllTodosTest() {
        List<Todo> expected = new ArrayList<>(Arrays.asList(new Todo("test")));

        when(todoRepository.findAll()).thenReturn(expected);
        List<Todo> actual = todoSvc.getAllTodos();

        assertEquals(expected, actual);
        verify(todoRepository).findAll();
    }

    @Test
    public void saveAndUpdateTodoTest() {
        Todo newTodo = new Todo("second");
        List<Todo> expected = new ArrayList<>(Arrays.asList(new Todo("test"), newTodo));

        when(todoRepository.findAll()).thenReturn(expected);
        List<Todo> actual = todoSvc.saveAndUpdateTodo(newTodo);

        assertEquals(expected, actual);
        verify(todoRepository).save(eq(newTodo));
        verify(todoRepository).findAll();
    }

    @Test
    public void deleteTodoTest() {
        List<Todo> expected = new ArrayList<>();
        String id = "1";

        when(todoRepository.findAll()).thenReturn(expected);

        List<Todo> actual = todoSvc.deleteTodo(id);

        assertEquals(expected, actual);
        verify(todoRepository).deleteById(id);
    }

    @Test(expected = NullPointerException.class)
    public void deleteTodoNullIDTest() {
        todoSvc.deleteTodo(null);
    }
}
