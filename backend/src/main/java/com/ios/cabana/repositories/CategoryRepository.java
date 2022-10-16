package com.ios.cabana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.cabana.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
