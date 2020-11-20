package com.qweather.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISPOSITIVOS")
public class Dispositivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "CODIGO", length = 5, nullable = false)
	private String codigo;
	
	@Column(name = "UBICACION", nullable = false)
	private String ubicacion;
	
	@Column(name = "LONGITUD", nullable = false)
	private String longitud;
	
	@Column(name = "LATITUD", nullable = false)
	private String latitud;
	
	
	public Dispositivo(int id) {
		this.id = id;
	}

	public Dispositivo() {}
	
	public Dispositivo(int id, String codigo, String ubicacion, String longitud, String latitud) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.longitud = longitud;
		this.latitud = latitud;
	}


	// Setters & Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
