package com.taskmanager.infrastructure.adapter.in.web;

import com.taskmanager.application.port.in.CreateTaskUseCase;
import com.taskmanager.domain.model.Task;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase){
        this.createTaskUseCase = createTaskUseCase;
    }



    @PostMapping ("/api/tasks")  //Define la ruta para crear tareas mediante una petición HTTP POST.
    public Task createTask (@RequestBody CreateTaskRequest request){  //Spring convierte el JSON recibido en un objeto Java con los datos de la tarea.
        return createTaskUseCase.createTask(  //Llama a la lógica de aplicación, que crea la tarea y utiliza el adaptador de persistencia para guardarla en MySQL.
                request.getTitle(),
                request.getDescription(),
                request.getDueDate(),
                request.getAssignedUserId());

        //return devuelve la tarea creada. Spring la convierte en una respuesta JSON.
    }
}
