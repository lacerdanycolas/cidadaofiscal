package com.example.cidadaofiscal.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Fornecedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6463458242217105538L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	//@ManyToMany(mappedBy="fornecedor",targetEntity= Deputado.class)
	//private Collection<Deputado> deputados;
	
	//@ManyToMany()
	
	
}
