package com.example.cidadaofiscal.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import lombok.Data;

@Entity
@Data
public class cfAlepe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3382706944180292241L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    @Fetch(FetchMode.JOIN)
	private String parlamentar_fantasia;
    @Fetch(FetchMode.JOIN)
	private String parlamentar_partido;
    @Fetch(FetchMode.JOIN)
	private String parlamentar_nome;
    @Fetch(FetchMode.JOIN)
	private Date parlamentar_dtnasc;
	
	private Double ordem_tipo;
	private String ordem_id;
	private Double ordem_valor;
	private Double ordem_ano;
	private Double ordem_mes;
	
	private Double despesa_tipo;
	private Date despesa_data;
	private Double despesa_valor;
	private TinyIntTypeDescriptor despesa_cancelada;
	
	private String fornecedor_nome;
	private Long fornecedor_id;
	
	
	
	
}
