package com.ios.cabana.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ios.cabana.dto.ProductDTO;
import com.ios.cabana.entities.Product;
import com.ios.cabana.repositories.CategoryRepository;
import com.ios.cabana.repositories.ProductRepository;
import com.ios.cabana.services.exceptions.DataBaseException;
import com.ios.cabana.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(Pageable pageable) {
		Page<Product> list = productRepository.findAll(pageable);
		return list.map(x -> new ProductDTO(x));
	}

	@Transactional(readOnly= true)
	public ProductDTO findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		try {
			copyDtoToEntity(dto, entity);
			entity.setCategory(categoryRepository.getReferenceById(dto.getCategoryDTO().getId()));
			entity = productRepository.save(entity);
			return new ProductDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error - Registro: " + dto.getId() + " não existe!");
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Error - Permissão de codigo:" + dto.getCategoryDTO().getId() + " não existe!");
		}

	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = productRepository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity.setCategory(categoryRepository.getReferenceById(dto.getCategoryDTO().getId()));
			entity = productRepository.save(entity);
			return new ProductDTO(entity);			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		}
	}

	public void delete(Long id) {
		try {
			productRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Error - Registro: " + id + " não existe!");
		}  catch(DataBaseException e) {
			throw new DataBaseException("Error - Registro: " + id + " esta associado com produtos!");
		}
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setNumber(dto.getNumber());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setUrlImage(dto.getUrlImage());
		entity.setDate(dto.getDate());
		entity.setPrice(dto.getPrice());
	}
}
