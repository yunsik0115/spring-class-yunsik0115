package com.jscode.day6;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductJpaRepository productJpaRepository;

    public ProductService(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public List<ProductEntity> findAll() {
        return productJpaRepository.findAll();
    }

    public ProductEntity findById(Long id){
        return productJpaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<ProductEntity> findByName(String name){
        return productJpaRepository.findByName(name);
    }

    public List<ProductEntity> findByNameAndPrice(String name, Long price){
        return productJpaRepository.findByNameAndPrice(name, price);
    }

    public List<ProductEntity> findByPrice(Long price){
        return productJpaRepository.findByPrice(price);
    }

    public ProductEntity save(ProductEntity product){
        return productJpaRepository.save(product);
    }
}
