package com.pe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.app.entidades.Contrato;
import com.pe.app.entidades.Distrito;
import com.pe.app.entidades.Especialidad;
import com.pe.app.entidades.Estudiante;
import com.pe.app.entidades.Profesor;
import com.pe.app.entidades.Servicio;
import com.pe.app.servicios.ServicioApp;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ControllerApp {

	@Autowired(required=true)
	private ServicioApp servicioApp;
	
	// 1)
	@Secured("ROLE_ADMIN")
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
	
	// 4a)
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/estudiante/registrar")
	public Estudiante registrarEstudianteSD(@RequestBody Estudiante estudiante) {
		return servicioApp.registrarEstudianteSD(estudiante);
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
	@Secured("ROLE_ADMIN")
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
	/*
	@PostMapping("/profesor/registrar/{idEspecialidad}")
	public Profesor registrarProfesor(@PathVariable(value = "idEspecialidad") Long idEspecialidad, @RequestBody Profesor profesor) {
		return servicioApp.registrarProfesor(idEspecialidad, profesor);
	}
	*/
	
	// 12.1)
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/profesor/registrarse")
	public Profesor registrarProfesorSE(@RequestBody Profesor profesor) {
		return servicioApp.registrarProfesorSE(profesor);
	}

	
	//12.3)

	@GetMapping("/profesor/registrarDist/{idProfesor}/{idDistrito}")
	public String addDist(@PathVariable(value = "idProfesor") Long idProfesor, @PathVariable(value = "idDistrito") Long idDistrito) {
		return servicioApp.addDist(idProfesor, idDistrito);
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
	
	// 16)
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/servicio/registrar")
	public Servicio registrarServicio(@RequestBody Servicio servicio) {
		return servicioApp.registrarServicio(servicio);
	}
	
	// 17)
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/servicios/mostrar")
	public List<Servicio> mostrarServicios() {
		return servicioApp.obtenerServicios();
	}
	
	// 18)
	@GetMapping("/servicio/buscar/{idServicio}")
	public Servicio buscarServicio(@PathVariable(value = "idServicio") Long idServicio) {
		return servicioApp.obtenerServicio(idServicio);
	}

	// 19) 
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/contrato/registrar")
	public Contrato registrarContrato(@RequestBody Contrato contrato) {
		return servicioApp.registrarContrato(contrato);
	}
	
	// 20) 
	//@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/contratos/mostrar")
	public List<Contrato> mostrarContratos() {
		return servicioApp.obtenerContratos();
	}
	
	// 21)
	@GetMapping("/contrato/buscar/{idContrato}")
	public Contrato buscarContrato(@PathVariable(value = "idContrato") Long idContrato) {
		return servicioApp.obtenerContrato(idContrato);
	}
	
	// 22)
	@GetMapping("/reserva/{idServicio}/{idContrato}")
	public String generarReserva(@PathVariable(value = "idServicio") Long idServicio, @PathVariable(value = "idContrato") Long idContrato) {
		return servicioApp.reservar(idServicio, idContrato);
	}


}


