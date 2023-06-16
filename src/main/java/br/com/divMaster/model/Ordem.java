package br.com.divMaster.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import br.com.divMaster.Enun.StatusOrdem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Ordem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	@JoinColumn
	private Usuarios user;
	@Column
	private String enderecoEntrega;
	@Column
	private BigDecimal quantidade;
	@Column
	private BigDecimal frete;
	@Column
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private StatusOrdem status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaPedido;
	
}
