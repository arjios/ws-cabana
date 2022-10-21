package com.ios.cabana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ios.cabana.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
