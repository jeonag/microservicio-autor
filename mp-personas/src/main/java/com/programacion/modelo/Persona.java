package com.programacion.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String cedula;
	private String direccion;
	private String nombre;
	private Integer tipodireccion_id;
	@Transient
	public TipoDireccion tipoDireccion;
	

	public Persona() {
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTipodireccion_id() {
		return tipodireccion_id;
	}

	public void setTipodireccion_id(Integer tipodireccion_id) {
		this.tipodireccion_id = tipodireccion_id;
	}

}
