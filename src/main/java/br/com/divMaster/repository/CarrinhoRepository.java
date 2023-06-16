package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

	
}
