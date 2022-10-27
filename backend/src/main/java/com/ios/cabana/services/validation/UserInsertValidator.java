package com.ios.cabana.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ios.cabana.dto.UserInsertDTO;
import com.ios.cabana.entities.User;
import com.ios.cabana.repositories.UserRepository;
import com.ios.cabana.resources.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UserInsertValid uiv) {
	}
	
	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
	
		List<FieldMessage> list = new ArrayList<>();
		
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user != null) {
			list.add(new FieldMessage("email", "Email já existe"));
		}

		for (FieldMessage fm : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fm.getFieldMessage()).addPropertyNode(fm.getFieldError())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}

