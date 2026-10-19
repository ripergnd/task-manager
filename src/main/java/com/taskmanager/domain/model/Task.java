package com.taskmanager.domain.model;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
    private Long assignedUserId;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public Task(String title, String description, LocalDate dueDate, Long assignedUserId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.assignedUserId = assignedUserId;
        this.status = TaskStatus.PENDING;
    }

    public boolean changeTitle(String newTitle) {

        if (newTitle == null || newTitle.isBlank()) {
            return false;
        }
        this.title = newTitle;
        return true;
    }

    public boolean start() {
        if (status == TaskStatus.PENDING) {
            status = TaskStatus.IN_PROGRESS;
            return true;
        }
        return false;
    }

    public boolean complete() {
        if (status == TaskStatus.IN_PROGRESS) {
            status = TaskStatus.COMPLETED;
            return true;

        }
        return false;
    }

    public Task (Long id, String title, String description, LocalDate dueDate, TaskStatus status, Long assignedUserId){

        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.assignedUserId = assignedUserId;
    }
}