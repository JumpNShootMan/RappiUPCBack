package com.pe.app.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TP_ESTUDIANTE")
public class Estudiante {

    // ***** ATRIBUTOS *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    private String nomEstudiante;

    private String apellidoProfesor;

    private int nroReservas;

    private int edad;

    private String genero;

    private String celularEstudiante;

    private String claveEstudiante; // para log-in

    private String codigoEstudiante; // codigo del centro de estudios

    private String dniEstudiante;

    private String direccionEstudiante;

    @ManyToOne
    @JoinColumn(name = "CODIGO_DISTRITO")
    @JsonIgnore
    private Distrito distrito;


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

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
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

}
