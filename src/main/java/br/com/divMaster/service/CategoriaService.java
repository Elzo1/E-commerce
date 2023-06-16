package br.com.divMaster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divMaster.model.Categorias;
import br.com.divMaster.repository.CategoriaRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categorias> findAll() {
		return repository.findAll();

	}

	public Categorias findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Categoria Com idNão Encontrado"));
	}

	public Categorias criar(Categorias categorias) {
		return repository.save(categorias);
	}

	public Categorias updade(Categorias categorias) {
		var Entity = repository.findById(categorias.getId())
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Categoria Não Encontrada"));

		Entity.setNome(categorias.getNome());
		return repository.save(categorias);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
