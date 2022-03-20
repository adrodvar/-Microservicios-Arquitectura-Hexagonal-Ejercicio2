package com.example.core.usecases;

import com.example.config.domain.exceptions.UserExistException;
import com.example.config.domain.model.User;
import com.example.ports.out.OutboundInterfaceUserCreator;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    private final OutboundInterfaceUserCreator creator;

    public CreateUserUseCase(OutboundInterfaceUserCreator creator) {
        this.creator = creator;
    }

    public User excecute() throws UserExistException {
        return creator.create();
    }
}
