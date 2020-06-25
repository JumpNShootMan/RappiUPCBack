package com.pe.app.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.app.entidades.Distrito;
import com.pe.app.entidades.Especialidad;
import com.pe.app.entidades.Estudiante;
import com.pe.app.entidades.Profesor;
import com.pe.app.repositorios.RepositorioDistrito;
import com.pe.app.repositorios.RepositorioEspecialidad;
import com.pe.app.repositorios.RepositorioEstudiante;
import com.pe.app.repositorios.RepositorioProfesor;

@Service
public class ServicioApp {

    @Autowired(required = true)
    private RepositorioDistrito repositorioDistrito;

    @Autowired(required = true)
    private RepositorioEstudiante repositorioEstudiante;

    @Autowired(required = true)
    private RepositorioEspecialidad repositorioEspecialidad;

    @Autowired(required = true)
    private RepositorioProfesor repositorioProfesor;


    // 1) Agregar un Distrito:
    @Transactional(rollbackOn = Exception.class)
    public Distrito registrarDistrito(Distrito distrito) {
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
    public Estudiante registrarEstudiante(Long idDistrito, Estudiante estudiante) {
        Distrito distrito = repositorioDistrito.obtenerDistrito(idDistrito);
        estudiante.setDistrito(distrito);
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
	
	public Profesor registrarProfesor(Profesor profesor) {
		List<Especialidad> especialidad = null;
		profesor.setEspecialidades(especialidad);
		Profesor profe = repositorioProfesor.save(profesor);
		return profe;
	}
	
	//12.1) Agregar Especialidades al profesor:
	@Transactional(rollbackOn = Exception.class)
	public String addEspec(Long idProfesor, Long idEspecialidad){
		
		Especialidad e = repositorioEspecialidad.obtenerEspecialidad(idEspecialidad);
	    Profesor p = repositorioProfesor.obtenerId(idProfesor);
	    p.addEspecialidad(e);
	    e.addProfesor(p);
	    repositorioProfesor.save(p);
	    repositorioEspecialidad.save(e);
	    return "Funciona!";

	    }
	
	//12.2) Agregar Distritos al profesor:
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

}