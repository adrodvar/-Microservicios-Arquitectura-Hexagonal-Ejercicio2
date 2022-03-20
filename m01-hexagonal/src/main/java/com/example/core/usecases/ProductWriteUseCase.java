package com.example.core.usecases;

import com.example.core.domain.Product;
import com.example.core.usecases.exception.InvalidProductCost;
import com.example.ports.in.ProductWriteInPort;
import com.example.ports.out.ProductWriteOutPort;

import java.time.LocalDateTime;

public class ProductWriteUseCase implements ProductWriteInPort {

    private ProductWriteOutPort productWritePort;

    public ProductWriteUseCase(ProductWriteOutPort productWritePort) {
        this.productWritePort = productWritePort;
    }

    @Override
    public Product save(Product product) {
        product.setCreationDate(LocalDateTime.now());

        Double totalCost = calculateProductCost(product);
        product.setCost(totalCost);

//        if(totalCost < 0)
//            throw new InvalidProductCost("El coste no puede ser negativo!");

        // TODO - añadir conversión de moneda


        return productWritePort.save(product);
    }

    private Double calculateProductCost(Product product) {
        Double iva = product.getPrice() * 0.21;
        Double cost = product.getPrice() - iva;
        Double margin = cost - cost * 0.10;
        Double totalCost = product.getPrice() - iva - margin;
        return totalCost;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
