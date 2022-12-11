package com.ios.cabana.dto;

import java.io.Serializable;
import java.time.Instant;

import com.ios.cabana.entities.Order;
import com.ios.cabana.entities.Product;
import com.ios.cabana.entities.User;
import com.ios.cabana.entities.enuns.OrderStatus;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer account;
	private Instant moment;
	private OrderStatus status;

	private User user;
	private Product product;

	public OrderDTO() {
	}

	public OrderDTO(Long id, Integer account, Instant moment, OrderStatus status) {
		this.id = id;
		this.account = account;
		this.moment = moment;
		this.status = status;
	}

	public OrderDTO(Order entity) {
		id = entity.getId();
		account = entity.getAccount();
		moment = entity.getMoment();
		status = entity.getStatus();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public User getUsers() {
		return user;
	}

	public Product getProducts() {
		return product;
	}

}
