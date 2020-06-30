package com.pe.app.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	// Especialidad:
	@JoinTable(
	            name = "tp_profesor_especialidades",
	            joinColumns = @JoinColumn(name = "CODIGO_ESPECIALIDAD", nullable = false),
	            inverseJoinColumns = @JoinColumn(name = "CODIGO_PROFESOR", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("especialidad")
	private List<Profesor> profesores;
	
	// Servicio:
	@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Servicio> servicio;
	
	// Agregar Profesor:

    public void addProfesor(Profesor profesor) {
        if (this.profesores == null) {
            this.profesores = new ArrayList<>();
        }

        this.profesores.add(profesor);
    }

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
	public List<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	public List<Servicio> getServicio() {
		return servicio;
	}
	public void setServicio(List<Servicio> servicio) {
		this.servicio = servicio;
	}
	
}
