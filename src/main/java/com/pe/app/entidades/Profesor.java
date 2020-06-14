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

    @ManyToOne
    @JoinColumn(name = "CODIGO_ESPECIALIDAD")
    @JsonIgnore
    private Especialidad especialidad;


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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

}
