package com.ios.cabana.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ios.cabana.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Campo não pode ficar em branco.")
	@Size(min = 6, message = "Campo deve ter no minimo 6 caracteres.")
	private String password;

	public UserInsertDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
