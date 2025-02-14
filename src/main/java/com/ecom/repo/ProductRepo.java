package com.ecom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{

	public Product findByName(String name);
}
