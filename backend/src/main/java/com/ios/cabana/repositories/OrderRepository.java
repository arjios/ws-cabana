package com.ios.cabana.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.cabana.entities.Order;
import com.ios.cabana.entities.enuns.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByAccount(Integer account);
	
	List<Order> findByStatus(OrderStatus status);
}
