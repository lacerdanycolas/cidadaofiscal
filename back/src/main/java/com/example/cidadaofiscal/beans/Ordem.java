package com.example.cidadaofiscal.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Ordem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2924682054969808672L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String tipo;
	private Double valor;
	private Integer ano;
	private String mes;
	
//	@ManyToMany(mappedBy="ordem", targetEntity=Fornecedor.class)
//	private Collection<Fornecedor> fornecedores;
	
	
	
}
