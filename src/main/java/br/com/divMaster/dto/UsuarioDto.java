package br.com.divMaster.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class UsuarioDto {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String password;
	private String email;
	private String endereco;
	private String telefone;
	private Boolean ativo;
	
}
