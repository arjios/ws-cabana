package com.ios.cabana.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ios.cabana.dto.RoleDTO;
import com.ios.cabana.services.RoleService;


@RestController
@RequestMapping(value = "/roles")
public class RoleResource {

	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public ResponseEntity<List<RoleDTO>> findAll() {
		List<RoleDTO> list = roleService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RoleDTO> findById(@PathVariable Long id) {
		RoleDTO dto = roleService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping(value = "/admin")
	public ResponseEntity<RoleDTO> insert(@Valid @RequestBody RoleDTO dto) {
		 dto = roleService.insert(dto);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(dto.getId()).toUri(); 
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/admin/{id}")
	public ResponseEntity<RoleDTO> update(@PathVariable Long id, @Valid @RequestBody RoleDTO dto) {
		dto = roleService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/admin/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		roleService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
