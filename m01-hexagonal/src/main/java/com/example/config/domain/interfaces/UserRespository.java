package com.example.config.domain.interfaces;



import com.example.config.domain.model.Id;
import com.example.config.domain.model.User;

import java.util.Optional;

public interface UserRespository {
    public Optional<User> findById(Id id);
    public void save(User user);
}
