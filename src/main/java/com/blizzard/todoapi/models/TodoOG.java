package com.blizzard.todoapi.models;

public class TodoOG {
    private int id;
    private String task;
    private boolean done;

    public TodoOG(int id, String task) {
        this.id = id;
        this.task = task;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setIsDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }
}
