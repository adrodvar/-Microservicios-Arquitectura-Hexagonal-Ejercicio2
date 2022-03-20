package com.example.ports.in;

import com.example.core.domain.Product;

import java.util.List;

/*
Métodos de búsqueda / lectura de productos
 */
public interface ProductReadInPort {

    List<Product> findAll();

    List<Product> findAllByCategory(String category);

}
