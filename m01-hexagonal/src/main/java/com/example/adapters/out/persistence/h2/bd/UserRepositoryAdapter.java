package com.example.adapters.out.persistence.h2.bd;

import com.example.adapters.out.persistence.h2.entities.UserEntity;
import com.example.adapters.out.persistence.h2.repositories.UserRepository;
import com.example.config.domain.interfaces.UserRespository;
import com.example.config.domain.model.Id;
import com.example.config.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRespository {

    private final UserRepository repository;

    public UserRepositoryAdapter(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findById(Id id) {
        Optional<UserEntity> userEntity = repository.findById(id.getId());
        if (userEntity.isPresent()) {
            return Optional.of(new User());
        } else {
            return Optional.empty();
        }
    }

    public void save(User user) {
        UserEntity userEntity = new UserEntity(user.getId().getId()); //Todo send favorites
        repository.save(userEntity);
    }
}
