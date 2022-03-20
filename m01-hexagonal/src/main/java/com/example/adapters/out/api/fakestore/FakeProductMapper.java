package com.example.adapters.out.api.fakestore;

import com.example.adapters.in.api.rest.ProductRestDTO;
import com.example.core.domain.Product;

public interface FakeProductMapper {

//    static FakeProductDTO of(Product product){
//        return new ProductRestDTO(product.getId(), product.getName(), product.getCategory(),
//                product.getPrice(), product.getStock());
//    }

    static Product of(FakeProductDTO dto){
        return new Product(dto.id(), dto.title(),
                dto.category(), dto.price(),
                null, null, null);
    }
}
