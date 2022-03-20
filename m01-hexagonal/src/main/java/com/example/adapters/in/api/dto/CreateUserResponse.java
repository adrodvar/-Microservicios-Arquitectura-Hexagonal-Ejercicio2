package com.example.adapters.in.api.dto;

public class CreateUserResponse {

    private String Id;

    public CreateUserResponse(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public CreateUserResponse() {
    }
}
