package com.taskmanager.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TaskTest {
    @Test
    void newTaskShouldBePending() {

        Task task = new Task(
                "Aprender Java",
                "Estudiar JUnit",
                LocalDate.now(),
                1L

        );

        Assertions.assertEquals(TaskStatus.PENDING, task.getStatus());
    }

    @Test
    void startShouldMoveTaskFromPendingToInProgress() {

        Task task = new Task(
                "Prepara cena",
                "Hacer macarrones con queso",
                LocalDate.now(),
                2L
        );

        task.start();

        Assertions.assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    void completeShouldFailWhenTaskIsPending() {

        Task task = new Task(
                "Tests",
                "Probar test con JUnit",
                LocalDate.now(),
                3L
        );

        boolean result = task.complete();

        Assertions.assertFalse(result);

        Assertions.assertEquals(TaskStatus.PENDING, task.getStatus());
    }

    @Test
    void completeShouldMoveTaskFromInProgressToCompleted() {

        Task task = new Task(
                "Notas",
                "Valorar las notas de los alumnos",
                LocalDate.now(),
                4L
        );

        task.start();

        boolean result = task.complete();

        Assertions.assertTrue(result);

        Assertions.assertEquals(TaskStatus.COMPLETED, task.getStatus());
    }

    @Test
    void callingStartTwoTimesShouldBeFalse() {

        Task task = new Task(
                "Ejercicio",
                "Hacer peso muerto",
                LocalDate.now(),
                5L
        );

        task.start();

        boolean result = task.start();

        Assertions.assertFalse(result);

        Assertions.assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());


    }

    @Test
    void validChangeTitleTest() {

        Task task = new Task(
                "Trabajo",
                "Hacer pagina web",
                LocalDate.now(),
                6L
        );

        boolean result = task.changeTitle("Tarea");

        Assertions.assertTrue(result);


        Assertions.assertEquals("Tarea", task.getTitle());
    }


    @Test
    void titleBeingEmptyShouldBeFalse() {

        Task task = new Task(
                "Estudio",
                "Aprender a programar",
                LocalDate.now(),
                7L
        );

        boolean result = task.changeTitle("");

        Assertions.assertFalse(result);

        Assertions.assertEquals("Estudio", task.getTitle());
    }

    @Test
    void titleBeingNullShouldBeFalse() {

        Task task = new Task(
                "Estudio",
                "Aprender a programar",
                LocalDate.now(),
                7L
        );

        boolean result = task.changeTitle(null);

        Assertions.assertFalse(result);

        Assertions.assertEquals("Estudio", task.getTitle());
    }

    @Test
    void callingStartWhenItsCompletedShouldBeFalse() {

        Task task = new Task(
                "Ejercicio",
                "Hacer peso muerto",
                LocalDate.now(),
                5L
        );

        task.start();

        task.complete();

        boolean result = task.start();

        Assertions.assertFalse(result);

        Assertions.assertEquals(TaskStatus.COMPLETED, task.getStatus());
    }
}
