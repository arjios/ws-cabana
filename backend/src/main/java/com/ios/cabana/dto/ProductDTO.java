package com.ios.cabana.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.ios.cabana.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer number;
	@NotBlank(message = "Campo não pode ficar em branco.")
	private String name;
	private String description;
	private String urlImage;
	@PastOrPresent(message = "Campo não pode ter data futura.")
	private Instant date;
	@Positive(message = "O campo preço deve ser positivo.")
	private Double price;

	private CategoryDTO categoryDTO;

	public ProductDTO() {

	}

	public ProductDTO(Long id, Integer number, String name, String description, String urlImage, Instant date,
			Double price) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.description = description;
		this.urlImage = urlImage;
		this.date = date;
		this.price = price;
//		this.categoryDTO = new CategoryDTO(category);
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		number = entity.getNumber();
		name = entity.getName();
		description = entity.getDescription();
		urlImage = entity.getUrlImage();
		date = entity.getDate();
		price = entity.getPrice();
//		categoryDTO = new CategoryDTO(entity.getCategory());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

}
