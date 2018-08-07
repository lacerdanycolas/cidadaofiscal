package com.example.cidadaofiscal.beans;

public class FornecedorDTO {
	
	public String fornecedor_nome;
	public String soma;
	public String deputados_contador;
	
	public FornecedorDTO(String fornecedor_nome, String soma, String deputados_contador) {
		super();
		this.fornecedor_nome = fornecedor_nome;
		this.soma = soma;
		this.deputados_contador = deputados_contador;
	}
	
	public FornecedorDTO() {
		
	}

	public String getFornecedor_nome() {
		return fornecedor_nome;
	}

	public void setFornecedor_nome(String fornecedor_nome) {
		this.fornecedor_nome = fornecedor_nome;
	}

	public String getSoma() {
		return soma;
	}

	public void setSoma(String soma) {
		this.soma = soma;
	}

	public String getDeputados_contador() {
		return deputados_contador;
	}

	public void setDeputados_contador(String deputados_contador) {
		this.deputados_contador = deputados_contador;
	}
}
