package com.blizzard.todoapi.services;

import com.blizzard.todoapi.models.TodoOG;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoSvcImpl implements ITodoSvc {
    // TODO: for now have in internally store todos
    private List<TodoOG> todos = new ArrayList<>();

    @Override
    public TodoOG getTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).toList().get(0);
    }

    @Override
    public List<TodoOG> getTodos() {
        return todos;
    }

    @Override
    public List<TodoOG> addTodo(TodoOG todo) {
        todos.add(todo);
        return todos;
    }

    @Override
    public List<TodoOG> updateTodo(int id, TodoOG todo) {
        for (TodoOG t : todos) {
            if (t.getId() == id) {
                t.setIsDone(todo.isDone());
                t.setTask(todo.getTask());
                break;
            }
        }

        return todos;
    }

    @Override
    public List<TodoOG> deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
        return todos;
    }
}
