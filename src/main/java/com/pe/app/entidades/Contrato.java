package com.pe.app.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TP_CONTRATO")
public class Contrato {
	
	// ***** ATRIBUTOS *****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_CONTRATO")
	private Long idContrato;
	
	private String nombreServicio;
	
	private String nomEstudiante;
	
	private String apellidoEstudiante;
	
	private String direccionEstudinate;
	
	private String nomProfesor;
	
	private String apellidoProfesor;
	
	private String year;
	
	private String mes;
	
	private String dia;
	
	private String confirmado;
	
	private float calificacion;
	
	private double costo;
	
	private String nombreEspecialidad;
	

	// Estudiante
	@ManyToOne
	@JoinColumn(name = "idEstudiante")
	private Estudiante estudiante;
	
	// Servicio
	@ManyToOne
	@JoinColumn(name = "CODIGO_SERVICIO")
	private Servicio servicio;
	
	// ***** GETTERS & SETTERS *****
	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(String confirmado) {
		this.confirmado = confirmado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio() {
		this.nombreServicio = this.servicio.getNomServicio();
	}

	public String getNomEstudiante() {
		return nomEstudiante;
	}

	public void setNomEstudiante() {
		this.nomEstudiante = this.estudiante.getNomEstudiante();
	}

	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}

	public void setApellidoEstudiante() {
		this.apellidoEstudiante = this.estudiante.getApellidoEstudiante();
	}

	public String getDireccionEstudinate() {
		return direccionEstudinate;
	}

	public void setDireccionEstudinate() {
		this.direccionEstudinate = this.estudiante.getDireccionEstudiante();
	}

	public String getNomProfesor() {
		return nomProfesor;
	}

	public void setNomProfesor( ) {
		this.nomProfesor = this.servicio.getProfesor().getNomProfesor();
	}

	public String getApellidoProfesor() {
		return apellidoProfesor;
	}

	public void setApellidoProfesor() {
		this.apellidoProfesor = this.servicio.getProfesor().getApellidoProfesor();
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad() {
		this.nombreEspecialidad = this.servicio.getProfesor().getEspecialidad().getNomEspecialidad();
	}
	
}
