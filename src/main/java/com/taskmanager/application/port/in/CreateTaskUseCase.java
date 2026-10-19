package com.taskmanager.application.port.in;

import com.taskmanager.domain.model.Task;

import java.time.LocalDate;

public interface CreateTaskUseCase {

    Task createTask(String title,
                           String description,
                           LocalDate dueDate,
                           Long assignedUserId);



}
