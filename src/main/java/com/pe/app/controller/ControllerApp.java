package com.pe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.app.entidades.Distrito;
import com.pe.app.entidades.Especialidad;
import com.pe.app.entidades.Estudiante;
import com.pe.app.entidades.Profesor;
import com.pe.app.servicios.ServicioApp;

@RestController
@RequestMapping("/api")
public class ControllerApp {
    //test git
    @Autowired(required = true)
    private ServicioApp servicioApp;

    // 1)
    @PostMapping("/distrito/registrar")
    public Distrito registrarDistrito(@RequestBody Distrito distrito) {
        return servicioApp.registrarDistrito(distrito);
    }

    // 2)
    @GetMapping("/distrito/{idDistrito}")
    public Distrito mostrarDistrito(@PathVariable(value = "idDistrito") Long idDistrito) {
        return servicioApp.obtenerDistrito(idDistrito);
    }

    // 3)
    @GetMapping("/distritos/mostrar")
    public List<Distrito> mostrarDistritos() {
        return servicioApp.obtenerDistritos();
    }

    // 4)
    @PostMapping("/estudiante/registrar/{idDistrito}")
    public Estudiante registrarEstudiante(@PathVariable(value = "idDistrito") Long idDistrito, @RequestBody Estudiante estudiante) {
        return servicioApp.registrarEstudiante(idDistrito, estudiante);
    }

    // 5)
    @GetMapping("/estudiante/buscar/id/{idEstudiante}")
    public Estudiante mostrarEstudiante(@PathVariable(value = "idEstudiante") Long idEstudiante) {
        return servicioApp.obtenerEstudiante(idEstudiante);
    }

    // 6)
    @GetMapping("/estudiante/buscar/dni/{dniEstudiante}")
    public Estudiante buscarEstudiante_DNI(@PathVariable(value = "dniEstudiante") String dniEstudiante) {
        return servicioApp.obtenerEstudiante_DNI(dniEstudiante);
    }

    // 7)
    @GetMapping("/estudiantes/mostrar")
    public List<Estudiante> mostrarEstudiantes() {
        return servicioApp.obtenerEstudiantes();
    }

    // 8)
    @GetMapping("/estudiante/ubicar/{idEstudiante}")
    public String distritoEstudiante(@PathVariable(value = "idEstudiante") Long idEstudiante) {
        return servicioApp.distritoEstudiante(idEstudiante);
    }

    // 9)
    @PostMapping("/especialidad/registrar")
    public Especialidad registrarEspecialidad(@RequestBody Especialidad especialidad) {
        return servicioApp.registrarEspecialidad(especialidad);
    }

    // 10)
    @GetMapping("/especialidad/{idEspecialidad}")
    public Especialidad mostrarEspecialidad(@PathVariable(value = "idEspecialidad") Long idEspecialidad) {
        return servicioApp.obtenerEspecialidad(idEspecialidad);
    }

    // 11)
    @GetMapping("/especialidad/mostrar")
    public List<Especialidad> mostrarEspecialidad() {
        return servicioApp.obtenerEspecialidades();
    }

    // 12)
    @PostMapping("/profesor/registrar/{idEspecialidad}")
    public Profesor registrarProfesor(@PathVariable(value = "idEspecialidad") Long idEspecialidad, @RequestBody Profesor profesor) {
        return servicioApp.registrarProfesor(idEspecialidad, profesor);
    }

    //12a
    @PostMapping("/profesor/registrarse")
    public Profesor registrarProfesorSE(@RequestBody Profesor profesor) {
        return servicioApp.registrarProfesorSE(profesor);
    }

    // 13)
    @GetMapping("/profesor/buscar/id/{idProfesor}")
    public Profesor buscarProfesor_ID(@PathVariable(value = "idProfesor") Long idProfesor) {
        return servicioApp.obtenerProfesor(idProfesor);
    }

    // 14)
    @GetMapping("/profesor/buscar/dni/{dniProfesor}")
    public Profesor buscarProfesor_DNI(@PathVariable(value = "dniProfesor") Long dniProfesor) {
        return servicioApp.obtenerProfesor(dniProfesor);
    }

    // 15)
    @GetMapping("/profesores/mostrar")
    public List<Profesor> mostrarProfesores() {
        return servicioApp.obtenerProfesores();
    }

}

