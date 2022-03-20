package com.example.config.domain.model;


public class User {

    private Id id;

    public User(){
        this.id = new Id();
    }

    public Id getId(){
        return this.id;
    }
}
