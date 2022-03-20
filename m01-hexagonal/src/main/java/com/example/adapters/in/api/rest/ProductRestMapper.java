package com.example.adapters.in.api.rest;

import com.example.core.domain.Product;

public interface ProductRestMapper {

    static ProductRestDTO of(Product product){
        return new ProductRestDTO(product.getId(), product.getName(), product.getCategory(),
                product.getPrice(), product.getStock());
    }

    static Product of(ProductRestDTO productRestDTO){
        return new Product(productRestDTO.id(), productRestDTO.name(),
                productRestDTO.category(), productRestDTO.price(), null, productRestDTO.stock(), null);
    }
}
