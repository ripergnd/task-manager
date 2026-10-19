package com.taskmanager.infrastructure.adapter.in.web;


import java.time.LocalDate;




public class CreateTaskRequest {

    private String title;
    private String description;
    private LocalDate dueDate;
    private Long assignedUserId;

    public CreateTaskRequest(String title, String description, LocalDate dueDate, Long assignedUserId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.assignedUserId = assignedUserId;
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

    public Long getAssignedUserId() {
        return assignedUserId;
    }
    public CreateTaskRequest(){

    }
}
