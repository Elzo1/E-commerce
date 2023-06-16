package br.com.divMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divMaster.model.Usuarios;

public interface UserRepository extends JpaRepository<Usuarios, Long> {

	boolean existsByEmail(String email);

	 Usuarios findByEmail(String email);

	Usuarios findFirstByEmail(String email);
	
}
