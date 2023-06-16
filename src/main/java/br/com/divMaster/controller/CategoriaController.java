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

import br.com.divMaster.model.Categorias;
import br.com.divMaster.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public List<Categorias> findAll() {
		return service.findAll();
	}

	@GetMapping("{id}")
	public Categorias findById(@PathVariable("id")Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Categorias criar( @RequestBody Categorias categorias) {
		return service.criar( categorias);
	}
	
	@PutMapping
	public Categorias update(@RequestBody Categorias categorias) {
		return service.updade(categorias);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		service.delete(id);
	 return ResponseEntity.noContent().build();
	}
	
}
