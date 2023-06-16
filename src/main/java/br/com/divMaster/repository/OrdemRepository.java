package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Ordem;

public interface OrdemRepository extends JpaRepository<Ordem, Long>{

}
