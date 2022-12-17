package com.ios.cabana.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.cabana.dto.OrderDTO;
import com.ios.cabana.entities.Order;
import com.ios.cabana.entities.User;
import com.ios.cabana.entities.enuns.OrderStatus;
import com.ios.cabana.repositories.OrderRepository;
import com.ios.cabana.repositories.UserRepository;
import com.ios.cabana.services.exceptions.DataBaseException;
import com.ios.cabana.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Transactional(readOnly = true)
	public Page<OrderDTO> findAllPaged(Pageable pageable) {
		Page<Order> list = orderRepository.findAll(pageable);
		return list.map(x -> new OrderDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAllPagedByAccount(Integer account) {
		List<Order> list = orderRepository.findByAccount(account);
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAllPagedByStatus(OrderStatus orderStatus) {
		List<Order> list = orderRepository.findByStatus(orderStatus);
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO openAccount(Integer account, Long userId) {
		Optional<User> obj = userRepository.findById(userId);
		User entityUser = obj.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
		Order entity = new Order();
		try {
			entity.setUserId(entityUser.getId());
			entity.setProductId(null);
			entity.setAccount(account);
			entity.setMoment(Instant.now());
			entity.setStatus(OrderStatus.OPEN);
			entity = orderRepository.save(entity);
			return new OrderDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error - Registro: " + account + " Já existe!");
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Error - Permissão de codigo:" + account + " Já existe!");
		}

	}
	
	
}
