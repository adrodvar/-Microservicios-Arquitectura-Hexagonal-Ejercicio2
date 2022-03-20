package com.example.adapters.out.persistence.sqldatabase.springdatajpa;

import com.example.core.domain.Product;
import com.example.ports.out.ProductReadOutPort;
import com.example.ports.out.ProductWriteOutPort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.security.KeyStore;
import java.util.HexFormat;
import java.util.List;

public class ProductDAO implements ProductReadOutPort, ProductWriteOutPort{

    private ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Ejemplo sin clase mapper
//    @Override
//    public List<Product> findAll() {
//        return productRepository.findAll().stream()
//                .map(pe -> new Product(
//                        pe.getId(), pe.getName(), pe.getCategory(),
//                        pe.getPrice(),pe.getCost(), pe.getStock(),
//                        pe.getCreationDate()))
//                .toList();
//    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .map(ProductEntityMapper::of)
                .toList();
    }

    @Override
    public List<Product> findAllByCategory(String category) {
        return productRepository.findAllByCategory(category).stream()
                .map(ProductEntityMapper::of)
                .toList();
    }


    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntityMapper.of(product); // mapeo dominio a entidad
        this.productRepository.save(entity);
        return ProductEntityMapper.of(entity); // mapeo entidad a dominio
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

}
