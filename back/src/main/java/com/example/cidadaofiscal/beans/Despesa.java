package com.example.cidadaofiscal.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import lombok.Data;

@Entity
@Data
public class Despesa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 552408401890232797L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Id
	
	private String tipo;
	
	private Double valor; 
	private Date data;
	private TinyIntTypeDescriptor cancelada;
	
//	
//	@ManyToMany(mappedBy="despesa", targetEntity=Deputado.class)
//	private Collection<Deputado> deputados;
	
	
}
