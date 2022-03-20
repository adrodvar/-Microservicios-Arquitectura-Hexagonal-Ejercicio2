package com.example.config.domain.service;

import com.example.config.domain.exceptions.UserExistException;
import com.example.config.domain.interfaces.UserRespository;
import com.example.config.domain.model.User;
import com.example.ports.in.InboundInterfaceUserCreator;
import org.springframework.stereotype.Service;

@Service
public class UserCreator  implements InboundInterfaceUserCreator {

    private final UserRespository repository;

    public UserCreator(UserRespository repository) {
        this.repository = repository;
    }

    public User create() throws UserExistException {
        User user  = new User();
        repository.save(user);
        return user;
    }

    @Override
    public User excecute() {
        return null;
    }
}
