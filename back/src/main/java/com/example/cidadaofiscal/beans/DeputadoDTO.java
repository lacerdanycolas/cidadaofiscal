package com.example.cidadaofiscal.beans;



public class DeputadoDTO {
	public String parlamentar_fantasia;
	public String despesa_media_mes;
	public String soma;
	
	public DeputadoDTO(String parlamentar_fantasia, String despesa_media_mes, String soma) {
		super();
		this.parlamentar_fantasia = parlamentar_fantasia;
		this.despesa_media_mes = despesa_media_mes;
		this.soma = soma;
	}
	
	public DeputadoDTO() {
		
	}
	
	public String getParlamentar_fantasia() {
		return parlamentar_fantasia;
	}
	public void setParlamentar_fantasia(String parlamentar_fantasia) {
		this.parlamentar_fantasia = parlamentar_fantasia;
	}
	public String getDespesa_media_mes() {
		return despesa_media_mes;
	}
	public void setDespesa_media_mes(String despesa_media_mes) {
		this.despesa_media_mes = despesa_media_mes;
	}
	public String getSoma() {
		return soma;
	}
	public void setSoma(String soma) {
		this.soma = soma;
	}
}
