package com.example.cidadaofiscal.beans;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="cf_alepe")
@Cacheable
public class CfAlepe {
	

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String parlamentar_fantasia;
   
	private String parlamentar_partido;
  
	private String parlamentar_nome;
  
	private String parlamentar_dtnasc;
	
	private Double ordem_tipo;
	private String ordem_id;
	private Double ordem_valor;
	private Double ordem_ano;
	private Double ordem_mes;
	
	private Double despesa_tipo;
	private String despesa_data;
	private Double despesa_valor;
	private String despesa_cancelada;
	
	private Long fornecedor_id;
	private String fornecedor_nome;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParlamentar_fantasia() {
		return parlamentar_fantasia;
	}
	public void setParlamentar_fantasia(String parlamentar_fantasia) {
		this.parlamentar_fantasia = parlamentar_fantasia;
	}
	public String getParlamentar_partido() {
		return parlamentar_partido;
	}
	public void setParlamentar_partido(String parlamentar_partido) {
		this.parlamentar_partido = parlamentar_partido;
	}
	public String getParlamentar_nome() {
		return parlamentar_nome;
	}
	public void setParlamentar_nome(String parlamentar_nome) {
		this.parlamentar_nome = parlamentar_nome;
	}
	public String getParlamentar_dtnasc() {
		return parlamentar_dtnasc;
	}
	public void setParlamentar_dtnasc(String parlamentar_dtnasc) {
		this.parlamentar_dtnasc = parlamentar_dtnasc;
	}
	public Double getOrdem_tipo() {
		return ordem_tipo;
	}
	public void setOrdem_tipo(Double ordem_tipo) {
		this.ordem_tipo = ordem_tipo;
	}
	public String getOrdem_id() {
		return ordem_id;
	}
	public void setOrdem_id(String ordem_id) {
		this.ordem_id = ordem_id;
	}
	public Double getOrdem_valor() {
		return ordem_valor;
	}
	public void setOrdem_valor(Double ordem_valor) {
		this.ordem_valor = ordem_valor;
	}
	public Double getOrdem_ano() {
		return ordem_ano;
	}
	public void setOrdem_ano(Double ordem_ano) {
		this.ordem_ano = ordem_ano;
	}
	public Double getOrdem_mes() {
		return ordem_mes;
	}
	public void setOrdem_mes(Double ordem_mes) {
		this.ordem_mes = ordem_mes;
	}
	public Double getDespesa_tipo() {
		return despesa_tipo;
	}
	public void setDespesa_tipo(Double despesa_tipo) {
		this.despesa_tipo = despesa_tipo;
	}
	public String getDespesa_data() {
		return despesa_data;
	}
	public void setDespesa_data(String despesa_data) {
		this.despesa_data = despesa_data;
	}
	public Double getDespesa_valor() {
		return despesa_valor;
	}
	public void setDespesa_valor(Double despesa_valor) {
		this.despesa_valor = despesa_valor;
	}
	public String getDespesa_cancelada() {
		return despesa_cancelada;
	}
	public void setDespesa_cancelada(String despesa_cancelada) {
		this.despesa_cancelada = despesa_cancelada;
	}
	public Long getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Long fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public String getFornecedor_nome() {
		return fornecedor_nome;
	}
	public void setFornecedor_nome(String fornecedor_nome) {
		this.fornecedor_nome = fornecedor_nome;
	}
	
	/*@Query(
			value= "SELECT \n" + 
			"	parlamentar_fantasia,\n" + 
			"	AVG(despesa_soma_mes) AS despesa_media_mes,\n" + 
			"	sum(despesa_soma_mes) as soma\n" + 
			"FROM\n" + 
			"	(SELECT \n" + 
			"		parlamentar_fantasia,\n" + 
			"		SUM(despesa_valor) AS despesa_soma_mes\n" + 
			"	FROM\n" + 
			"		cidadaofiscal.cf_alepe\n" + 
			"	GROUP BY\n" + 
			"		parlamentar_fantasia,\n" + 
			"		ordem_ano,\n" + 
			"		ordem_mes) AS month_sum\n" + 
			"GROUP BY parlamentar_fantasia\n" + 
			"ORDER BY soma desc\n" + 
			"             \n" + 
			" ",
			nativeQuery = true)
	<T> Collection<T> getDeputadosSomasEMedias(Class<T> type);*/
	
}
