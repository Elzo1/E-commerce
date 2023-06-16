package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.OrdemItem;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, Long> {

}
