package com.pe.app.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TP_DISTRITO")
public class Distrito {
	// ***** ATRIBUTOS *****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_DISTRITO")
	private Long idDistrito;
	
	@NotEmpty(message ="no puede estar vacio")
	private String nomDistrito;
	
	@NotEmpty(message ="no puede estar vacio")
	private String nomProvincia;
	
	/*
	// Estudiante:
	@OneToMany(mappedBy = "distrito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Estudiante> estudiantes;
	*/

	
	//Profesores:
    @ManyToMany(mappedBy = "distritos")
    @JsonIgnoreProperties("profesor")
    private List<Profesor> profesores;

	
	// ***** GETTERS & SETTERS *****
	public Long getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getNomDistrito() {
		return nomDistrito;
	}
	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}
	public String getNomProvincia() {
		return nomProvincia;
	}
	public void setNomProvincia(String nomProvincia) {
		this.nomProvincia = nomProvincia;
	}

	/*
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	*/

    public List<Profesor> getProfesores() {
        return profesores;

    }
    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

}

