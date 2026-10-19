package com.taskmanager.infrastructure.adapter.out.persistence;

import com.taskmanager.application.port.out.TaskRepositoryPort;
import com.taskmanager.domain.model.Task;


import java.util.ArrayList;
import java.util.List;

public class TaskPersistenceAdapter implements TaskRepositoryPort {

    @Override
    public List<Task> findAll (){
        List<TaskEntity> entities = taskJpaRepository.findAll();
        List<Task> tasks = new ArrayList<>();
        for (TaskEntity entity : entities){
            tasks.add(entity.toDomain());
        }
        return tasks;
    }

    private final TaskJpaRepository taskJpaRepository;

    public TaskPersistenceAdapter (TaskJpaRepository taskJpaRepository){
        this.taskJpaRepository = taskJpaRepository;

    }

    @Override
    public Task save(Task task) {

        TaskEntity taskEntity;
        taskEntity = new TaskEntity(task);

        TaskEntity saveEntity = taskJpaRepository.save(taskEntity);


        return saveEntity.toDomain();
    }
}
