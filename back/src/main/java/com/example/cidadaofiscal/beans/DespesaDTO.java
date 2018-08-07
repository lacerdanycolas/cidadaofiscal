package com.example.cidadaofiscal.beans;

public class DespesaDTO {
	
	public String despesa_tipo;
	public String y2015;
	public String y2016;
	public String y2017;
	public String total;

	public DespesaDTO(String despesa_tipo, String y2015, String y2016, String y2017, String total) {
		super();
		this.despesa_tipo = despesa_tipo;
		this.y2015 = y2015;
		this.y2016 = y2016;
		this.y2017 = y2017;
		this.total = total;
	}

	public DespesaDTO() {
	
	}
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getDespesa_tipo() {
		return despesa_tipo;
	}
	public void setDespesa_tipo(String despesa_tipo) {
		this.despesa_tipo = despesa_tipo;
	}
	public String getY2015() {
		return y2015;
	}
	public void setY2015(String y2015) {
		this.y2015 = y2015;
	}
	public String getY2016() {
		return y2016;
	}
	public void setY2016(String y2016) {
		this.y2016 = y2016;
	}
	public String getY2017() {
		return y2017;
	}
	public void setY2017(String y2017) {
		this.y2017 = y2017;
	}
	
	
}
