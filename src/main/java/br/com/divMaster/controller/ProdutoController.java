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

import br.com.divMaster.model.Produto;
import br.com.divMaster.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public List<Produto> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Produto findById(@PathVariable("id")Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Produto criate( @RequestBody Produto produto) {
		
		return service.criate(produto);
	}
	
	
	
	@PutMapping
	public Produto update(@RequestBody Produto produto) {
		return service.updade(produto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		service.delete(id);
	 return ResponseEntity.noContent().build();
	}
	
}
