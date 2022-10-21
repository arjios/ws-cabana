package com.ios.cabana.dto;

import java.io.Serializable;

import com.ios.cabana.entities.Category;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String urlImage;
	
	public CategoryDTO() {
	}

	public CategoryDTO(Long id, String name, String urlImage) {
		this.id = id;
		this.name = name;
		this.urlImage = urlImage;
	}
	
	public CategoryDTO(Category entity) {
		id = entity.getId();
		name = entity.getName();
		urlImage = entity.getUrlImage();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
