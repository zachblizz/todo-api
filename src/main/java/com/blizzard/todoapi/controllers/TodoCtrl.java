package com.blizzard.todoapi.controllers;

import com.blizzard.todoapi.services.TodoSvcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blizzard.todoapi.models.TodoOG;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/todo")
public class TodoCtrl {
    @Autowired
    private TodoSvcImpl todoSvc;

    @GetMapping
    public List<TodoOG> getTodos() {
        return todoSvc.getTodos();
    }

    @GetMapping("/{id}")
    public TodoOG getTodo(@PathVariable Integer id) {
        return todoSvc.getTodo(id);
    }

    @PutMapping
    public List<TodoOG> addTodo(@RequestBody TodoOG todo) {
        return todoSvc.addTodo(todo);
    }

    @PatchMapping("/{id}")
    public List<TodoOG> updateTodo(@PathVariable(required = true) Integer id, @RequestBody TodoOG todo) {
        return todoSvc.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public List<TodoOG> deleteTodo(@PathVariable Integer id) {
        return todoSvc.deleteTodo(id);
    }
}
