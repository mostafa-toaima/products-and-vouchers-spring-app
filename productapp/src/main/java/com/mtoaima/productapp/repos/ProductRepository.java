package com.mtoaima.productapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtoaima.productapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
