package com.example.adapters.in.gui;

import com.example.core.domain.Product;

public interface ProductWebMapper {

    static ProductWebDTO of(Product product){
        return new ProductWebDTO(product.getId(), product.getName(), product.getCategory(),
                product.getPrice());
    }

    static Product of(ProductWebDTO productWebDTO){
        return new Product(productWebDTO.id(), productWebDTO.name(),
                productWebDTO.category(), productWebDTO.price(), null, null, null);
    }
}
