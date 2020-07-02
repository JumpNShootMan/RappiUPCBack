package com.pe.app.entidades;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;


@Entity
@Table(name = "TP_ESPECIALIDAD")
public class Especialidad {

  
	// ***** ATRIBUTOS *****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_ESPECIALIDAD")
	private Long idEspecialidad;
	
	private String nomEspecialidad;
	
	private String descripcionEspecialidad;
	
	
	// ***** GETTERS & SETTERS *****
	public Long getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getNomEspecialidad() {
		return nomEspecialidad;
	}
	public void setNomEspecialidad(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
	}
	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}
	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}

	
}
