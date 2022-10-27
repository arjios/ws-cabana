package com.ios.cabana.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.ios.cabana.entities.Role;
import com.ios.cabana.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Campo não pode ficar em branco.")
	private String firstName;
	@NotBlank(message = "Campo não pode ficar em branco.")
	private String lastName;
	@Email(message = "Campo deve ter um email valido.")
	private String email;
	
	private RoleDTO role;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String email, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = new RoleDTO(role);
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		role = new RoleDTO(entity.getRole());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleDTO getRole() {
		return role;
	}

}
