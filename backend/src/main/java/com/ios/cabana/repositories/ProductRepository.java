package com.ios.cabana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.cabana.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
