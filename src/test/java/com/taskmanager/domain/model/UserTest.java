package com.taskmanager.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void newUserShouldHaveCorrectData(){

        User user = new User(
                "Laurentiu",
                "laurentiu@gmail.com"
        );

        Assertions.assertEquals("Laurentiu", user.getName());
        Assertions.assertEquals("laurentiu@gmail.com", user.getEmail());


    }

    @Test
    void validChangeNameShouldReturnTrue(){

        User user = new User(
                "Ramon",
                "Ramon@gmail.com"
        );

        boolean result = user.changeName("Ramoncin");

        Assertions.assertTrue(result);

        Assertions.assertEquals("Ramoncin", user.getName());
    }

    @Test
    void emptyNameShouldBeRejected(){

        User user = new User(
                "Ramon",
                "Ramon@gmail.com"
        );

        boolean result = user.changeName("");

        Assertions.assertFalse(result);

        Assertions.assertEquals("Ramon",user.getName());
    }

    @Test
    void nullNameShouldBeRejected(){

        User user = new User(
                "Ramon",
                "Ramon@gmail.com"
        );

        boolean result = user.changeName(null);

        Assertions.assertFalse(result);

        Assertions.assertEquals("Ramon",user.getName());
    }

    @Test
    void validChangeEmailShouldReturnTrue(){

        User user = new User(
                "Ramon",
                "Ramon@gmail.com"
        );

        boolean result = user.changeEmail("Ramoncin@gmail.com");

        Assertions.assertTrue(result);

        Assertions.assertEquals("Ramoncin@gmail.com", user.getEmail());
    }

    @Test
    void emptyEmailShouldBeRejected(){

        User user = new User(
                "Ramon",
                "Ramon@gmail.com"
        );

        boolean result = user.changeEmail("");

        Assertions.assertFalse(result);

        Assertions.assertEquals("Ramon@gmail.com", user.getEmail());
    }

    @Test
    void nullEmailShouldBeRejected(){

        User user = new User(
                "Ramon",
                "Ramon@gmail.com"
        );

        boolean result = user.changeEmail(null);

        Assertions.assertFalse(result);

        Assertions.assertEquals("Ramon@gmail.com", user.getEmail());
    }

}
