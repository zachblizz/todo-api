package com.blizzard.todoapi.controllers;

import com.blizzard.todoapi.models.Todo;
import com.blizzard.todoapi.services.TodoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/todo-mdb")
public class TodoCtrl {
    @Autowired
    TodoSvc svc;

    @GetMapping
    public List<Todo> getTodos() {
        return svc.getAllTodos();
    }

    @PutMapping
    public List<Todo> addTodo(@RequestBody Todo todo) {
        return svc.saveTodo(todo);
    }

    @PatchMapping("/{id}")
    public List<Todo> updateTodo(@PathVariable String id, @RequestBody Todo todo) {
        return svc.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodo(@PathVariable String id) {
        return svc.deleteTodo(id);
    }
}
