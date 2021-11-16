package com.blizzard.todoapi.controllers;

import com.blizzard.todoapi.models.Todo;
import com.blizzard.todoapi.services.TodoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/todos")
public class TodoCtrl {
    @Autowired
    TodoSvc todoSvc;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoSvc.getAllTodos();
    }

    @PostMapping
    public List<Todo> addTodo(@RequestBody Todo todo) {
        return todoSvc.saveAndUpdateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodo(@PathVariable String id) {
        return todoSvc.deleteTodo(id);
    }
}
