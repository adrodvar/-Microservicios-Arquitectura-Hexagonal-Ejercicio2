package com.example.ports.out;

import com.example.config.domain.exceptions.UserExistException;
import com.example.config.domain.model.User;

public interface OutboundInterfaceUserCreator {
    User create() throws UserExistException;
    void validateExists(User user) throws UserExistException;
}
