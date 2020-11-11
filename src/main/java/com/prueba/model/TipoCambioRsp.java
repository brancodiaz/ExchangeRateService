package com.prueba.model;

public class TipoCambioRsp {

	private Double montoOrigen;
	private String monedaOrigen;
	private Double montoDestino;
	private String monedaDestino;
	private Double tipoCambio;
	
	public TipoCambioRsp() {}
	
	
	public TipoCambioRsp(Double montoOrigen, String monedaOrigen, Double montoDestino, String monedaDestino, Double tipoCambio) {
		super();
		this.montoOrigen = montoOrigen;
		this.monedaOrigen = monedaOrigen;
		this.montoDestino = montoDestino;
		this.monedaDestino = monedaDestino;
		this.tipoCambio = tipoCambio;
	}
	
	public Double getMontoOriginal() {
		return montoOrigen;
	}

	public void setMontoOriginal(Double montoOriginal) {
		this.montoOrigen = montoOriginal;
	}

	public Double getMontoResultado() {
		return montoDestino;
	}

	public void setMontoResultado(Double montoResultado) {
		this.montoDestino = montoResultado;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	
	public String getMonedaDestino() {
		return monedaDestino;
	}
	
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	
	public Double getTipoCambio() {
		return tipoCambio;
	}
	
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
}
