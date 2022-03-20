package com.example.adapters.out.persistence.h2.repositories;

import com.example.adapters.out.persistence.h2.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,String> {

}
