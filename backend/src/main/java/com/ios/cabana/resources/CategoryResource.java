package com.ios.cabana.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ios.cabana.entities.Category;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Bebidas"));
		list.add(new Category(2L, "Coqueteis"));
		list.add(new Category(3L, "Petiscos"));
		list.add(new Category(4L, "Peixes"));
		list.add(new Category(5L, "Aves"));
		list.add(new Category(6L, "Carnes"));
		return ResponseEntity.ok().body(list);
	}
	
}
