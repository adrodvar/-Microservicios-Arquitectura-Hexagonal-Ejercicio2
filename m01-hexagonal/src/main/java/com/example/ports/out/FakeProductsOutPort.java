package com.example.ports.out;

import com.example.core.domain.Product;

import java.util.List;

public interface FakeProductsOutPort {

    List<Product> fetchAll();
}
