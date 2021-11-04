package com.blizzard.todoapi.services;

import com.blizzard.todoapi.models.Todo;
import com.blizzard.todoapi.repository.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoSvc {
    @Autowired
    private ITodoRepository todoRepo;

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public List<Todo> saveTodo(Todo todo) {
        todoRepo.save(todo);
        return todoRepo.findAll();
    }

    public List<Todo> updateTodo(String id, Todo todo) {
        try {
            Todo tmp = todoRepo.findById(id).get();

            if (tmp != null) {
                tmp.setTask(todo.getTask());
                tmp.setDone(todo.isDone());

                todoRepo.save(tmp);
            }
        } catch (NoSuchElementException e) {
            System.out.println("No such element");
        }

        return todoRepo.findAll();
    }

    public List<Todo> deleteTodo(String id) {
        todoRepo.deleteById(id);
        return todoRepo.findAll();
    }
}
