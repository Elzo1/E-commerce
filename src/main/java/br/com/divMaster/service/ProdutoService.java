package br.com.divMaster.service;

import java.util.List;

import org.hibernate.metamodel.UnsupportedMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.divMaster.model.Produto;
import br.com.divMaster.repository.CategoriaRepository;
import br.com.divMaster.repository.ProdutoRepository;
import br.com.divMasterException.unsupportedMathOperatioExceptio;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository repositori;
	

	public List<Produto> findAll() {
		return repository.findAll();
				
	}
	
	
	public Produto findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new unsupportedMathOperatioExceptio("Categoria Com id" +id+ "Não Encontrado"));
	}
	
	public Produto criate( Produto produto) {
		
		// verifica se o nome da categoria foi preenchido
		if(!StringUtils.hasText(produto.getNome())) {
			throw new unsupportedMathOperatioExceptio("O Nome do Produto não pode ser vazia!");
		}
		
		// verifica se tem  uma categoria
		if(produto.getCategoria() == null) {
			throw new unsupportedMathOperatioExceptio("A Categoria não pode ser vazia!");
		}
		// verifica se categoria  tem um ID
		if(produto.getCategoria().getId() == null) {
			throw new unsupportedMathOperatioExceptio("O ID de Categoria não pode ser vazia!");
		}
		
		repositori.findById(produto.getCategoria().getId())
		.orElseThrow(() -> new unsupportedMathOperatioExceptio("ID da Categoria "+ produto.getCategoria().getId()+ "Não encontrados" ));
			return repository.save(produto);

					
	}
	
	public Produto updade( Produto produto) {
		var Entity = repository.findById(produto.getId())
				.orElseThrow(()-> new unsupportedMathOperatioExceptio("Categoria Não Encontrada"));
		
		
		Entity.setNome(produto.getNome());
		Entity.setDescricao(produto.getDescricao());
		Entity.setImagem(produto.getImagem());
		Entity.setCategoria(produto.getCategoria());
		Entity.setPreco(produto.getPreco());
		Entity.setEstoque(produto.getEstoque());
		
		return repository.save(produto);
	}
	
	

	public Produto mudarImagem(Long id, String imagem) {
		Produto produto = findById(id);
		produto.setImagem(imagem);
		return repository.save(produto);
	}
	

	public void delete(Long id) {
		repository.deleteById(id);
	}


	public Produto findById1(Long produtoId) {

		Object produto = repositori.findById(produtoId);
		if(produto == null) {
			throw new UnsupportedMappingException("Poduto Não existe");
		}
		return null;
	}


	
}
