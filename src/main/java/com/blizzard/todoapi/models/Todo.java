package com.blizzard.todoapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("todos")
public class Todo {
    @Id
    private String id;
    private String task;
    private boolean done;

    public Todo() { super(); }

    public Todo(String task) {
        super();

        this.task = task;
        this.done = false;
    }

    public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
