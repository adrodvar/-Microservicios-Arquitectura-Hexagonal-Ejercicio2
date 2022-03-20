package com.example.core.domain;


import com.example.config.domain.exceptions.UserExistException;
import com.example.config.domain.interfaces.UserRespository;
import com.example.config.domain.model.User;
import com.example.ports.out.OutboundInterfaceUserCreator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCreator implements OutboundInterfaceUserCreator {

    private final UserRespository repository;

    public UserCreator(UserRespository repository) {
        this.repository = repository;
    }

    public User create() throws UserExistException {
        User user  = new User();
        validateExists(user);
        repository.save(user);
        return user;
    }

    public void validateExists(User user) throws UserExistException {
        Optional<User> byId = repository.findById(user.getId());
        if(byId.isPresent()){
            throw new UserExistException();
        }

    }

}
