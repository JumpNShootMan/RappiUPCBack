package com.pe.app.entidades;

import java.lang.reflect.Constructor;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TP_SERVICIO")
public class Servicio {

	// ***** ATRIBUTOS *****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_SERVICIO")
	private Long idServicio;
	
	private String nomServicio;
	
	private String descripcionServicio;
	
	private double costoServicio;
	
	private String dia;
	
	private String hora;
	

	// Profesor
	/*
	@ManyToOne
	@JoinColumn(name = "CODIGO_PROFESOR")
<<<<<<< Updated upstream

	private Profesor profesor;
		
	private String nombreEspecialidad;
		
=======
	@JsonIgnore
	private Profesor profesor;
	*/
	@ManyToOne
	@JoinColumn(name = "CODIGO_PROFESOR")
	private Profesor profesor;
		
	private String nombreEspecialidad;
	
	/*
	// Especialidad
	@ManyToOne
	@JoinColumn(name = "CODIGO_ESPECIALIDAD")
	@JsonIgnore
	private Especialidad especialidad;
	
	// Contrato
	@OneToMany
	private List<Contrato> contratos;
	*/
	
	// ***** GETTERS & SETTERS *****
	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNomServicio() {
		return nomServicio;
	}

	public void setNomServicio(String nomServicio) {
		this.nomServicio = nomServicio;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public double getCostoServicio() {
		return costoServicio;
	}

	public void setCostoServicio(double costoServicio) {
		this.costoServicio = costoServicio;
	}

	/*
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	*/

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setNombreEspecialidad() {
		this.nombreEspecialidad = this.profesor.getEspecialidad().getNomEspecialidad();
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/*
	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	*/

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

}
