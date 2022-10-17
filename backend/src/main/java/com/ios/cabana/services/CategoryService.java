package com.ios.cabana.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.cabana.dto.CategoryDTO;
import com.ios.cabana.entities.Category;
import com.ios.cabana.repositories.CategoryRepository;
import com.ios.cabana.services.exceptions.DataBaseException;
import com.ios.cabana.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly= true)
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRepository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly= true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return new CategoryDTO(obj.orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada")));
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = categoryRepository.save(entity);
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
			Category entity = categoryRepository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = categoryRepository.save(entity);
			return new CategoryDTO(entity);			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		}
	}

	public void delete(Long id) {
		try {
			categoryRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		}  catch(DataBaseException e) {
			throw new DataBaseException("Error - Registro: " + id + " esta associado com produtos!");
		}
	}
	
}
