package com.ios.cabana.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.cabana.dto.RoleDTO;
import com.ios.cabana.entities.Role;
import com.ios.cabana.repositories.RoleRepository;
import com.ios.cabana.services.exceptions.DataBaseException;
import com.ios.cabana.services.exceptions.ResourceNotFoundException;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly= true)
	public List<RoleDTO> findAll() {
		List<Role> list = roleRepository.findAll();
		return list.stream().map(x -> new RoleDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly= true)
	public RoleDTO findById(Long id) {
		Optional<Role> obj = roleRepository.findById(id);
		return new RoleDTO(obj.orElseThrow(() -> new ResourceNotFoundException("Codigo da permissão não encontrada: ID=" + id)));
	}

	@Transactional
	public RoleDTO insert(RoleDTO dto) {
		Role entity = new Role();
		entity.setAuthority(dto.getAuthority());
		entity = roleRepository.save(entity);
		return new RoleDTO(entity);
	}

	@Transactional
	public RoleDTO update(Long id, RoleDTO dto) {
		try {
			Role entity = roleRepository.getReferenceById(id);
			entity.setAuthority(dto.getAuthority());
			entity = roleRepository.save(entity);
			return new RoleDTO(entity);			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		}
	}

	public void delete(Long id) {
		try {
			roleRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		} catch(DataBaseException e) {
			throw new DataBaseException("Error - Registro: " + id + " tem usuarios associados!");
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Error - Integridade referencial: Exclusão não permitida, existem usuarios associados a esta permissão");
		}
	}
	
}
