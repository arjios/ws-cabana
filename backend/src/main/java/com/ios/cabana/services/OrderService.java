package com.ios.cabana.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.cabana.dto.OrderDTO;
import com.ios.cabana.entities.Order;
import com.ios.cabana.entities.OrderStatus;
import com.ios.cabana.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Transactional(readOnly = true)
	public Page<OrderDTO> findAllPaged(Pageable pageable) {
		Page<Order> list = orderRepository.findAll(pageable);
		return list.map(x -> new OrderDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAllPagedByStatus(OrderStatus orderStatus) {
		List<Order> list = orderRepository.findByStatus(orderStatus);
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
