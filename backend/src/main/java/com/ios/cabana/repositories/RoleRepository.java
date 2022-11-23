package com.ios.cabana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.cabana.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
