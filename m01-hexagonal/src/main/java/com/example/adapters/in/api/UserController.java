package com.example.adapters.in.api;

import com.example.adapters.in.api.dto.CreateUserResponse;
import com.example.config.domain.exceptions.UserExistException;
import com.example.config.domain.model.User;
import com.example.ports.in.InboundInterfaceUserCreator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/pokemon/user")
public class UserController {

    private final InboundInterfaceUserCreator useCase;

    public UserController(InboundInterfaceUserCreator useCase) {
        this.useCase = useCase;
    }

    @PostMapping(path = "/create-user")
    public ResponseEntity<CreateUserResponse> createCart() throws UserExistException {
        User user = useCase.excecute();
        return ResponseEntity.ok(new CreateUserResponse(user.getId().getId()));
    }

}
