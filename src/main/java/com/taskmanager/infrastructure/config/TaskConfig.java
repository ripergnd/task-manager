package com.taskmanager.infrastructure.config;

import com.taskmanager.application.port.out.TaskRepositoryPort;
import com.taskmanager.application.service.CreateTaskService;
import com.taskmanager.infrastructure.adapter.out.persistence.TaskJpaRepository;
import com.taskmanager.infrastructure.adapter.out.persistence.TaskPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public TaskPersistenceAdapter taskPersistenceAdapter (TaskJpaRepository taskJpaRepository){

       return new TaskPersistenceAdapter(taskJpaRepository);
    }

    @Bean
    public CreateTaskService createTaskService (TaskRepositoryPort taskRepositoryPort){

        return new CreateTaskService(taskRepositoryPort);
    }

}
