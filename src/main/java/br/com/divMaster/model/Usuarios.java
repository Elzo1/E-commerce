package br.com.divMaster.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Usuarios implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private String endereco;
	
	@Column
	private String telefone;
	
	
	private Boolean ativo;
	
	public Usuarios(String email2) {

		this.email = email2;
	}
	
	}
