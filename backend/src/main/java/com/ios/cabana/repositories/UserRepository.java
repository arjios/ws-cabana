package com.ios.cabana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.cabana.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
