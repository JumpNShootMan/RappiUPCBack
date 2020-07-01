package com.pe.app.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.app.entidades.Contrato;
import com.pe.app.entidades.Distrito;
import com.pe.app.entidades.Especialidad;
import com.pe.app.entidades.Estudiante;
import com.pe.app.entidades.Profesor;
import com.pe.app.entidades.Servicio;
import com.pe.app.repositorios.RepositorioContrato;
import com.pe.app.repositorios.RepositorioDistrito;
import com.pe.app.repositorios.RepositorioEspecialidad;
import com.pe.app.repositorios.RepositorioEstudiante;
import com.pe.app.repositorios.RepositorioProfesor;
import com.pe.app.repositorios.RepositorioServicio;

@Service
public class ServicioApp {
	
	@Autowired(required=true)
	private RepositorioDistrito repositorioDistrito;
	
	@Autowired(required=true)
	private RepositorioEstudiante repositorioEstudiante;

	@Autowired(required=true)
	private RepositorioEspecialidad repositorioEspecialidad;
	
	@Autowired(required=true)
	private RepositorioProfesor repositorioProfesor;
	
	@Autowired(required=true)
	private RepositorioServicio repositorioServicio;
	
	@Autowired(required=true)
	private RepositorioContrato repositorioContrato;
	
	
	// 1) Agregar un Distrito:
	@Transactional(rollbackOn = Exception.class)
	public Distrito registrarDistrito(Distrito distrito) {
		
		// Profesor:
		List<Profesor> profesor = null;
		distrito.setProfesores(profesor);
		
		return repositorioDistrito.save(distrito);
	}
	
	// 2) Mostrar un Distrito:
	public Distrito obtenerDistrito(Long idDistrito) {
		return repositorioDistrito.obtenerDistrito(idDistrito);
	}
	
	// 3) Mostrar todos los Distritos:
	public List<Distrito> obtenerDistritos() {
		return repositorioDistrito.findAll(); 
	}
	
	// 4) Agregar un Estudiante:
	@Transactional(rollbackOn = Exception.class)
	public Estudiante registrarEstudiante(Long idDistrito ,Estudiante estudiante) {
		Distrito distrito = repositorioDistrito.obtenerDistrito(idDistrito);
		estudiante.setDistrito(distrito);
		return repositorioEstudiante.save(estudiante);
	}
	
	// 4a) Agregar un Estudiante :
	@Transactional(rollbackOn = Exception.class)
	public Estudiante registrarEstudianteSD(Estudiante estudiante) {
		return repositorioEstudiante.save(estudiante);
	}
	
	// 5) Buscar Estudiante x Id:
	public Estudiante obtenerEstudiante(Long idEstudiante) {
		return repositorioEstudiante.obtener(idEstudiante);
	}
	
	// 6) Buscar Estudiante x DNI:
	public Estudiante obtenerEstudiante_DNI(String dniEstudiante) {
		return repositorioEstudiante.obtenerDni(dniEstudiante);
	}
	
	// 7) Mostrar a todos los Estudiantes:
	public List<Estudiante> obtenerEstudiantes() {
		return repositorioEstudiante.findAll();
	}
	
	// 8) Ubicar Estudiante:
	public String distritoEstudiante(Long idEstudiante) {
		Estudiante e = repositorioEstudiante.obtener(idEstudiante);
		Distrito d = e.getDistrito();
		return d.getNomDistrito();
	}
	
	// 9) Agregar una Especialidad:
	@Transactional(rollbackOn = Exception.class)
	public Especialidad registrarEspecialidad(Especialidad especialidad) {
		return repositorioEspecialidad.save(especialidad);
	}
	
	// 10) Mostrar una Especialidad:
	public Especialidad obtenerEspecialidad(Long idEspecialidad) {
		return repositorioEspecialidad.obtenerEspecialidad(idEspecialidad);
	}
	
	// 11) Mostrar todas las Especialidades:
	public List<Especialidad> obtenerEspecialidades() {
		return repositorioEspecialidad.findAll(); 
	}
	
	// 12) Agregar un Profesor:
	
	@Transactional(rollbackOn = Exception.class)
	public Profesor registrarProfesorSE(Profesor profesor) {
		return repositorioProfesor.save(profesor);
	}
	
	
	//12.3) Agregar Distritos al profesor:
	@Transactional(rollbackOn = Exception.class)
	public String addDist(Long idProfesor, Long idDistrito){
		Distrito d = repositorioDistrito.obtenerDistrito(idDistrito);
	    Profesor p = repositorioProfesor.obtenerId(idProfesor);
	    p.addDistrito(d);
	    repositorioProfesor.save(p);
	    return "Funciona!";
	}
	
	// 13) Buscar Profesor x Id:
	public Profesor obtenerProfesor(Long idProfesor) {
		return repositorioProfesor.obtenerId(idProfesor);
	}
	
	// 14) Buscar Profesor x DNI:
	public Profesor obtenerProfesor(String dniProfesor) {
		return repositorioProfesor.obtenerDni(dniProfesor);
	}
	
	// 15) Mostrar a todos los Profesores:
	public List<Profesor> obtenerProfesores() {
		return repositorioProfesor.findAll();
	}

	
	// 16) Agregar un Servicio:
	@Transactional(rollbackOn = Exception.class)
	public Servicio registrarServicio(Servicio servicio) {
		return repositorioServicio.save(servicio);
	}
	
	// 17) Mostrar Todos los Servicios:
	public List<Servicio> obtenerServicios() {
		return repositorioServicio.findAll();
	}
	
	// 18) Buscar Servicio:	
	public Servicio obtenerServicio(Long idServicio) {
		return repositorioServicio.obtener(idServicio);
	}
	
	// 19) Agregar un Contrato
	@Transactional(rollbackOn = Exception.class)
	public Contrato registrarContrato(Contrato contrato) {
		/*
		// Estudiante
		Estudiante estudiante = repositorioEstudiante.obtener(idEstudiante);
		contrato.setEstudiante(estudiante);
		contrato.setApellidoEstudiante(estudiante.getApellidoEstudiante());
		contrato.setNomEstudiante(estudiante.getNomEstudiante());
		contrato.setDireccionEstudinate(estudiante.getDireccionEstudiante());
		contrato.setCalificacion(0);
		contrato.setConfirmado(null);
		
		// Servicio
		Servicio servicio = null;
		contrato.setServicio(servicio);*/
		return repositorioContrato.save(contrato);
	}
	
	// 20) Mostrar Todos los contratos:
	public List<Contrato> obtenerContratos() {
		return repositorioContrato.findAll();
	}
	
	// 21) Buscar Contrato:	
	public Contrato obtenerContrato(Long idContrato) {
		return repositorioContrato.obtener(idContrato);
	}
	
	// 22) Conectar Servicio Con Contrato --> GENERAR RESERVA
	public String reservar(Long idServicio, Long idContrato) {
		
		// Obtener Clases
		Contrato contrato = repositorioContrato.obtener(idContrato);
		Servicio servicio = repositorioServicio.obtener(idServicio);
		
		// Conectar
		contrato.setServicio(servicio);
		
		// Asiganar parametros:
		contrato.setNombreServicio(servicio.getNomServicio());
		contrato.setApellidoProfesor(servicio.getProfesor().getApellidoProfesor());
		contrato.setNomProfesor(servicio.getProfesor().getNomProfesor());
		contrato.setDia(servicio.getDia());
		contrato.setCosto(servicio.getCostoServicio());
		contrato.setNombreEspecialidad(servicio.getNombreEspecialidad());
		
		// Guardar Contrato
		repositorioContrato.save(contrato);
		String text = "Reserva realizada con exito - Falta confirmacion";
		return text;
	}


}