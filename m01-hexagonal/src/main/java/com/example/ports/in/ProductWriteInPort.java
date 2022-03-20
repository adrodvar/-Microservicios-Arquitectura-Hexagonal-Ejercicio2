package com.example.ports.in;

import com.example.core.domain.Product;

public interface ProductWriteInPort {

    Product save(Product product);

    Product update(Product product);

    void deleteById(Long id);
}
