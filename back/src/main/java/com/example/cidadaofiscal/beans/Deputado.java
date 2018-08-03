package com.example.cidadaofiscal.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Data
public class Deputado implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -693593544308793563L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=cfAlepe.class)
	@JoinColumn(name="parlamentar_fantasia", referencedColumnName="parlamentar_fantasia")
	 @Fetch(FetchMode.JOIN)
	private String parlamentar_fantasia;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=cfAlepe.class)
	@JoinColumn(name="parlamentar_partido", referencedColumnName="parlamentar_partido")
	 @Fetch(FetchMode.JOIN)
	private String parlamentar_partido;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=cfAlepe.class)
	@JoinColumn(name="parlamentar_nome", referencedColumnName="parlamentar_nome")
	 @Fetch(FetchMode.JOIN)
	private String parlamentar_nome;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=cfAlepe.class)
	@JoinColumn(name="parlamentar_dtnasc", referencedColumnName="parlamentar_dtnasc")
	 @Fetch(FetchMode.JOIN)
	private Date parlamentar_dtnasc;
	

	
	
	
	
	
	
	
	
	
	
	
}
