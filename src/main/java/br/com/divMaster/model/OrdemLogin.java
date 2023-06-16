package br.com.divMaster.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
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
public class OrdemLogin implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ordem_id")
	private Ordem ordem;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Usuarios user;
	
	private Integer logType;
	private String logMessage;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
}
