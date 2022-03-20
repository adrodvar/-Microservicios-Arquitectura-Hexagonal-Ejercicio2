package com.example.core.usecases;

import com.example.core.domain.Product;
import com.example.ports.in.ProductReadInPort;
import com.example.ports.out.ProductReadOutPort;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProductReadUseCase implements ProductReadInPort {

    // Puerto de salida (Interfaz)(implementado por un adaptador de salida)
    private ProductReadOutPort productPort;

    public ProductReadUseCase(ProductReadOutPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public List<Product> findAll() {
        return this.productPort.findAll();
    }

    @Override
    public List<Product> findAllByCategory(String category) {
        return this.productPort.findAllByCategory(category);
    }
}
