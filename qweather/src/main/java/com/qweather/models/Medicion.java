package com.qweather.models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MEDICIONES")
public class Medicion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ID_DISPOSITIVO")
	private Dispositivo dispositivo;
		
	@Column(name = "CALIDADAIRE", nullable = false)
	private double calidadAire;

	@Column(name = "TIEMPO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar tiempo;

		
	//Methods	
	public int calcularPolucion() {
		
		String[] v_BP = { "0.0-4.4", "4.5-9.4", "9.5-12.4", "12.5-15.4", "15.5-30.4", "30.5-40.4", "40.5-50.4" };
		String[] v_ICA = { "0-50", "51-100", "101-150", "151-200", "200-300", "301-400", "401-500" };
		
		int ica = 0; 			// Indice calidad del aire
		double c = 0;			// Concentracion de contaminante en un periodo de tiempo (entre reportes)
		double bpHi = 0;		// limite mayor de concentracion por rango ICA
		double bpLo = 0;		// limite menor de concentracion por rango ICA
		int iHi = 0;			// Valor ICA correspondiente para el BPhi.
		int iLo = 0;
		
		c = getCalidadAire();
		
		double ll = 0.0, lh = 0.0 ;
		
		for (int i = 0; i < v_BP.length; i++) {
			String[] bp_limits = v_BP[i].split("-");
			String[] ica_limits = v_ICA[i].split("-");
			ll = Double.parseDouble(bp_limits[0]);
			lh = Double.parseDouble(bp_limits[1]);
			
			if(ll <= c && c <= lh) {
				bpLo = ll;
				bpHi = lh;
				iLo = Integer.parseInt(ica_limits[0]);
				iHi = Integer.parseInt(ica_limits[1]);
				break;
			}
		}
		
		ica = (int) (((iHi-iLo)/(bpHi-bpLo))*(c-bpLo)+iLo);
		
		return ica;
	}
	
	// Setters & Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public double getCalidadAire() {
		return calidadAire;
	}

	public void setCalidadAire(double calidadAire) {
		this.calidadAire = calidadAire;
	}

	public Calendar getTiempo() {
		return tiempo;
	}

	public void setTiempo(Calendar tiempo) {
		this.tiempo = tiempo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Medicion [id=" + id + ", dispositivo=" + dispositivo + ", calidadAire=" + calidadAire + ", tiempo="
				+ tiempo + "]";
	}
		
}
