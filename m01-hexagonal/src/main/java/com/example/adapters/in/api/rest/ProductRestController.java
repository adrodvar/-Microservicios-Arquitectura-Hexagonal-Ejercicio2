package com.example.adapters.in.api.rest;

import com.example.core.domain.Product;
import com.example.ports.in.ProductReadInPort;
import com.example.ports.in.ProductWriteInPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    // puertos de entrada al hexágono (interfaces)
    private ProductReadInPort productReadPort;
    private ProductWriteInPort productWritePort;

    public ProductRestController(ProductReadInPort productReadPort, ProductWriteInPort productWritePort) {
        this.productReadPort = productReadPort;
        this.productWritePort = productWritePort;
    }

    @GetMapping("/api/products")
    public List<ProductRestDTO> findAll(){
        return this.productReadPort.findAll().stream()
                .map(ProductRestMapper::of)
                .toList();
    }

    @GetMapping("/api/products/category/{category}")
    public List<ProductRestDTO> findAllByCategory(@PathVariable String category){
        return this.productReadPort.findAllByCategory(category).stream()
                .map(ProductRestMapper::of)
                .toList();
    }

    @PostMapping("/api/products")
    public ResponseEntity<ProductRestDTO> save(@RequestBody ProductRestDTO productRestDTO){
        Product productDB = this.productWritePort.save(ProductRestMapper.of(productRestDTO));
        return ResponseEntity.ok(ProductRestMapper.of(productDB));
    }
}
