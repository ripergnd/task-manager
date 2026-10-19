package com.taskmanager.infrastructure.adapter.out.persistence;

import com.taskmanager.domain.model.Task;
import com.taskmanager.domain.model.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Long assignedUserId;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public TaskEntity() {

    }
    public TaskEntity(Task task){
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.assignedUserId= task.getAssignedUserId();
        this.status= task.getStatus();
    }
    public Long getId(){
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

    public Long getAssignedUserId() {
        return assignedUserId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Task toDomain(){
        Task task = new Task(getId(),
                getTitle(),
                getDescription(),
                getDueDate(),
                getStatus(),
                getAssignedUserId());
        return task;
    }
}

