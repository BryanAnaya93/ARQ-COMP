package com.dashboard.models;

import java.sql.Timestamp;

public class Filtro {

	
	private String dispositivos;
	private Timestamp fec_fin;
	private Timestamp fec_inicio;
	
	public String getDispositivos() {
		return dispositivos;
	}
	
	public void setDispositivos(String dispositivos) {
		this.dispositivos = dispositivos;
	}
	
	public Timestamp getFec_fin() {
		return fec_fin;
	}
	
	public void setFec_fin(Timestamp fec_fin) {
		this.fec_fin = fec_fin;
	}
	
	public Timestamp getFec_inicio() {
		return fec_inicio;
	}
	
	public void setFec_inicio(Timestamp fec_inicio) {
		this.fec_inicio = fec_inicio;
	}	
	
}
