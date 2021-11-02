package com.blizzard.todoapi.services;

import com.blizzard.todoapi.models.TodoOG;

import java.util.List;

public interface ITodoSvc {
    public TodoOG getTodo(int id);
    public List<TodoOG> getTodos();
    public List<TodoOG> addTodo(TodoOG todo);
    public List<TodoOG> updateTodo(int id, TodoOG todo);
    public List<TodoOG> deleteTodo(int id);
}
