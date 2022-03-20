package com.example.adapters.out.persistence.sqldatabase.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategory(String category);
}