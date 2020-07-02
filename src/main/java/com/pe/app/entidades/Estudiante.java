package com.pe.app.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TP_ESTUDIANTE")
public class Estudiante implements Serializable{

	// ***** ATRIBUTOS *****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstudiante;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=4, max=12, message="el tamaño tiene que estar entre 4 y 12")
	@Column(nullable=false)
	private String nomEstudiante;
	
	@NotEmpty(message ="no puede estar vacio")
	private String apellidoEstudiante;
	
	@Min(value = 0, message = "El Nro. de Reservas tiene un valor minimo de 0")
	private int nroReservas;
	
	@Max(value = 100, message = "la edad maxima es de 100")
	@Min(value = 16, message = "la edad minima es de 16")
	private int edad;
	
	@NotEmpty(message ="no puede estar vacio")
	private String genero;
	
	@NotEmpty(message ="no puede estar vacio")
	private String celularEstudiante;
	
	@NotEmpty(message ="no puede estar vacio")
	private String claveEstudiante; // para log-in
	
	@NotEmpty(message ="no puede estar vacio")
	private String codigoEstudiante; // codigo del centro de estudios
	
	@NotEmpty(message ="no puede estar vacio")
	private String dniEstudiante;
	
	@NotEmpty(message ="no puede estar vacio")
	private String direccionEstudiante;
	
	// Distrito
	@ManyToOne
	@JoinColumn(name = "CODIGO_DISTRITO")
	private Distrito distrito;
	
	/*
	@NotNull(message="la región no puede ser vacia")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_DISTRITO")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private Distrito distrito;
	*/
	/*
	// Contrato
	@OneToMany
	private List<Contrato> contratos;
	*/
	
	
	// ***** GETTERS & SETTERS *****
	public Long getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public String getNomEstudiante() {
		return nomEstudiante;
	}
	public void setNomEstudiante(String nomEstudiante) {
		this.nomEstudiante = nomEstudiante;
	}
	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}
	public void setApellidoEstudiante(String apellidoEstudiante) {
		this.apellidoEstudiante = apellidoEstudiante;
	}
	public int getNroReservas() {
		return nroReservas;
	}
	public void setNroReservas(int nroReservas) {
		this.nroReservas = nroReservas;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCelularEstudiante() {
		return celularEstudiante;
	}
	public void setCelularEstudiante(String celularEstudiante) {
		this.celularEstudiante = celularEstudiante;
	}
	public String getClaveEstudiante() {
		return claveEstudiante;
	}
	public void setClaveEstudiante(String claveEstudiante) {
		this.claveEstudiante = claveEstudiante;
	}
	public String getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getDniEstudiante() {
		return dniEstudiante;
	}
	public void setDniEstudiante(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}
	public String getDireccionEstudiante() {
		return direccionEstudiante;
	}
	public void setDireccionEstudiante(String direccionEstudiante) {
		this.direccionEstudiante = direccionEstudiante;
	}
	public Distrito getDistrito() {
		return distrito;
	}
	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	/*
	public List<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	*/
	
	private static final long serialVersionUID = 1L;
}
