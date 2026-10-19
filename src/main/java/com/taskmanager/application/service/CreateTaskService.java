package com.taskmanager.application.service;

import com.taskmanager.application.port.in.CreateTaskUseCase;
import com.taskmanager.application.port.out.TaskRepositoryPort;
import com.taskmanager.domain.model.Task;



import java.time.LocalDate;

public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskService(TaskRepositoryPort taskRepositoryPort){
        this.taskRepositoryPort = taskRepositoryPort;
    }


    @Override
    public Task createTask(String title, String description, LocalDate dueDate, Long assignedUserId) {

        Task task = new Task(title,description,dueDate,assignedUserId);


        return taskRepositoryPort.save(task);
    }

}
