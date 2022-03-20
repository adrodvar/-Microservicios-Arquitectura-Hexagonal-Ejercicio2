package com.example.ports.out;

import com.example.core.domain.Product;

import java.util.List;


public interface ProductReadOutPort {

    List<Product> findAll();

    List<Product> findAllByCategory(String category);

}
