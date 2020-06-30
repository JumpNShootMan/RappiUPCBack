package com.pe.app.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TP_PROFESOR")
public class Profesor {
	
	// ***** ATRIBUTOS *****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfesor;
	
	private String nomProfesor;
	
	private String apellidoProfesor;
	
	private String dniProfesor;
	
	private double pagoMes;
	
	private String claveProfesor; // para log-in
	
	private String celularProfesor;
	
	private String generoProfesor;
	
	private float calificacion;
	
	// Especialidad
    @ManyToMany(mappedBy = "profesores")
    @JsonIgnoreProperties("especialidad")
    private List<Especialidad> especialidades;

	//Distritos a los que atiende
	 @JoinTable(
	            name = "tp_profesor_distritos",
	            joinColumns = @JoinColumn(name = "CODIGO_PROFESOR", nullable = false),
	            inverseJoinColumns = @JoinColumn(name = "CODIGO_DISTRITO", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("profesor")
    private List<Distrito> distritos;
	
	// Servicio
	@OneToMany
	private List<Servicio> servicios;
	
	// Agregar Especialidad:
    public void addEspecialidad(Especialidad especialidad) {
        if (this.especialidades == null) {
            this.especialidades = new ArrayList<>();
        }

        this.especialidades.add(especialidad);
    }
    
    // Agregar Distrito:
    public void addDistrito(Distrito distrito) {
        if (this.distritos == null) {
            this.distritos = new ArrayList<>();
        }

        this.distritos.add(distrito);
    }
	
	// ***** GETTERS & SETTERS *****
	public Long getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getNomProfesor() {
		return nomProfesor;
	}
	public void setNomProfesor(String nomProfesor) {
		this.nomProfesor = nomProfesor;
	}
	public String getApellidoProfesor() {
		return apellidoProfesor;
	}
	public void setApellidoProfesor(String apellidoProfesor) {
		this.apellidoProfesor = apellidoProfesor;
	}
	public String getDniProfesor() {
		return dniProfesor;
	}
	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}
	public double getPagoMes() {
		return pagoMes;
	}
	public void setPagoMes(double pagoMes) {
		this.pagoMes = pagoMes;
	}
	public String getClaveProfesor() {
		return claveProfesor;
	}
	public void setClaveProfesor(String claveProfesor) {
		this.claveProfesor = claveProfesor;
	}
	public String getCelularProfesor() {
		return celularProfesor;
	}
	public void setCelularProfesor(String celularProfesor) {
		this.celularProfesor = celularProfesor;
	}
	public String getGeneroProfesor() {
		return generoProfesor;
	}
	public void setGeneroProfesor(String generoProfesor) {
		this.generoProfesor = generoProfesor;
	}
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }
    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
	public List<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
    public List<Distrito> getDistritos() {
        return distritos;
    }
    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	
}
