package com.example.adapters.out.persistence.h2.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String id;


    public UserEntity() {
    }

    public UserEntity(String id) {

    }

    public void setId(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }



}
