package com.ios.cabana.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ios.cabana.dto.OrderDTO;
import com.ios.cabana.entities.enuns.OrderStatus;
import com.ios.cabana.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<Page<OrderDTO>> findAll(Pageable pageable) {
		Page<OrderDTO> list = orderService.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{status}")
	public ResponseEntity<List<OrderDTO>> findAllByStatus(OrderStatus status) {
		List<OrderDTO> list = orderService.findAllPagedByStatus(status);
		return ResponseEntity.ok().body(list);
	}
	
}
