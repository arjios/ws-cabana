package com.ios.cabana.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.cabana.dto.UserDTO;
import com.ios.cabana.dto.UserInsertDTO;
import com.ios.cabana.dto.UserUpdateDTO;
import com.ios.cabana.entities.User;
import com.ios.cabana.repositories.RoleRepository;
import com.ios.cabana.repositories.UserRepository;
import com.ios.cabana.services.exceptions.DataBaseException;
import com.ios.cabana.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> list = userRepository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}

	@Transactional(readOnly= true)
	public UserDTO findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		try {
			copyDtoToEntity(dto, entity);
			entity.setPassword(encoder.encode(dto.getPassword()));
			entity.setRole(roleRepository.getReferenceById(dto.getRole().getId()));
			entity = userRepository.save(entity);
			return new UserDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error - Registro: " + dto.getId() + " não existe!");
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Error - Permissão de codigo:" + dto.getRole().getId() + " não existe!");
		}

	}

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User entity = userRepository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity.setRole(roleRepository.getReferenceById(dto.getRole().getId()));
			entity = userRepository.save(entity);
			return new UserDTO(entity);			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		}
	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		}  catch(DataBaseException e) {
			throw new DataBaseException("Error - Registro: " + id + " esta associado com produtos!");
		}
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			logger.error("Usuario " +  username + " não existe!");
			throw new UsernameNotFoundException("Usuario " +  username + " não existe!");
		}
		logger.info("Usuario " +  username + " encontrado com sucesso");
		return user;
	}
}
