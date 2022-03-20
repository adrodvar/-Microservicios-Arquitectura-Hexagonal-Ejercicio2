package com.example.ports.in;

import com.example.config.domain.exceptions.UserExistException;
import com.example.config.domain.model.User;

public interface InboundInterfaceUserCreator {

     User excecute() throws UserExistException;

}
