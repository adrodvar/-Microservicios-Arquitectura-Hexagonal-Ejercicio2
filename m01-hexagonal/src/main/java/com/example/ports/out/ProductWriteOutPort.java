package com.example.ports.out;

import com.example.core.domain.Product;

public interface ProductWriteOutPort {

    Product save(Product product);

    Product update(Product product);

    void deleteById(Long id);
}
