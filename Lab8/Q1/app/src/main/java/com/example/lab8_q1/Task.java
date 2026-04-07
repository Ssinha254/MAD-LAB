package com.example.lab8_q1;


public class Task {
    private int id;
    private String taskName;
    private String dueDate;
    private String priority;

    public Task(int id, String taskName, String dueDate, String priority) {
        this.id = id;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }
}