package com.taskmanager.domain.model;

public class User {

    private Long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

    public boolean changeName (String newName){

        if (newName == null || newName.isBlank()){
            return false;
        }

        this.name = newName;
        return true;
    }

    public boolean changeEmail (String newEmail){

        if (newEmail == null || newEmail.isBlank()){
            return false;
        }

        this.email = newEmail;
        return true;
    }
}
