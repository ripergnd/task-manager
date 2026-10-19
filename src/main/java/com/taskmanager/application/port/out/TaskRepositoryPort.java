package com.taskmanager.application.port.out;

import com.taskmanager.domain.model.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskRepositoryPort {

    Task save(Task task);

    List<Task> findAll();
}
