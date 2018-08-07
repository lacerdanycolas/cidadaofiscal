package com.example.cidadaofiscal.beans;

public class PesquisaDTO {
	
	public String parlamentar_fantasia;
	public String parlamentar_partido;
	public String parlamentar_nome;
	public String ordem_ano;
	public String ordem_mes;
	public String fornecedor_id;
	public String fornecedor_nome;
	public String despesa_tipo;
	public String despesa_valor;
	public String despesa_cancelada;
	public String despesa_data;
	
	public PesquisaDTO() {
		
	}
	
	public PesquisaDTO(String parlamentar_fantasia, String parlamentar_partido, String parlamentar_nome, String ordem_ano,
			String ordem_mes, String fornecedor_id, String fornecedor_nome, String despesa_tipo, String despesa_valor,
			String despesa_cancelada, String despesa_data) {
		super();
		this.parlamentar_fantasia = parlamentar_fantasia;
		this.parlamentar_partido = parlamentar_partido;
		this.parlamentar_nome = parlamentar_nome;
		this.ordem_ano = ordem_ano;
		this.ordem_mes = ordem_mes;
		this.fornecedor_id = fornecedor_id;
		this.fornecedor_nome = fornecedor_nome;
		this.despesa_tipo = despesa_tipo;
		this.despesa_valor = despesa_valor;
		this.despesa_cancelada = despesa_cancelada;
		this.despesa_data = despesa_data;
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

	public String getOrdem_ano() {
		return ordem_ano;
	}

	public void setOrdem_ano(String ordem_ano) {
		this.ordem_ano = ordem_ano;
	}

	public String getOrdem_mes() {
		return ordem_mes;
	}

	public void setOrdem_mes(String ordem_mes) {
		this.ordem_mes = ordem_mes;
	}

	public String getFornecedor_id() {
		return fornecedor_id;
	}

	public void setFornecedor_id(String fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}

	public String getFornecedor_nome() {
		return fornecedor_nome;
	}

	public void setFornecedor_nome(String fornecedor_nome) {
		this.fornecedor_nome = fornecedor_nome;
	}

	public String getDespesa_tipo() {
		return despesa_tipo;
	}

	public void setDespesa_tipo(String despesa_tipo) {
		this.despesa_tipo = despesa_tipo;
	}

	public String getDespesa_valor() {
		return despesa_valor;
	}

	public void setDespesa_valor(String despesa_valor) {
		this.despesa_valor = despesa_valor;
	}

	public String getDespesa_cancelada() {
		return despesa_cancelada;
	}

	public void setDespesa_cancelada(String despesa_cancelada) {
		this.despesa_cancelada = despesa_cancelada;
	}

	public String getDespesa_data() {
		return despesa_data;
	}

	public void setDespesa_data(String despesa_data) {
		this.despesa_data = despesa_data;
	}
}
