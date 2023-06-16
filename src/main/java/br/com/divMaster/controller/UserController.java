package br.com.divMaster.controller;

import java.util.List;

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

import br.com.divMaster.model.Usuarios;
import br.com.divMaster.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@GetMapping
	public List<Usuarios> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Usuarios findById(@PathVariable("id")Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Usuarios criate( @RequestBody Usuarios usuarios) {
		
		return service.criate(usuarios);
	}
	
	
	@PutMapping
	public Usuarios update(@RequestBody Usuarios user) {
		return service.updade(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		service.delete(id);
	 return ResponseEntity.noContent().build();
	}
	
}