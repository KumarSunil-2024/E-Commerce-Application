package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Product;
import com.ecom.entity.User;
import com.ecom.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    
    public void createProduct(Product product) {
    	productRepo.save(product);
    }


    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    public void updateProduct(Product product) {
        productRepo.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product with id " + product.getId() + " not found"));
        productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
        productRepo.deleteById(id);
    }
}
