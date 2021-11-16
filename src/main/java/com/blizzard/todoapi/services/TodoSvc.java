package com.blizzard.todoapi.services;

import com.blizzard.todoapi.models.Todo;
import com.blizzard.todoapi.repository.ITodoRepository;
import graphql.com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoSvc {
    @Autowired
    private ITodoRepository todoRepo;

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public List<Todo> saveAndUpdateTodo(Todo todo) {
        todoRepo.save(todo);
        return todoRepo.findAll();
    }

    public List<Todo> deleteTodo(String id) {
        if (Strings.isNullOrEmpty(id)) {
            throw new NullPointerException("Must provide a Todo ID");
        }

        todoRepo.deleteById(id);
        return todoRepo.findAll();
    }
}
