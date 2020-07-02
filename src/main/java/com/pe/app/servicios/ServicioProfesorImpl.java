package com.pe.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.app.entidades.Especialidad;
import com.pe.app.entidades.Profesor;
import com.pe.app.repositorios.RepositorioProfesor;

@Service
public class ServicioProfesorImpl implements ServicioProfesor{

	@Autowired
	private RepositorioProfesor repositorioProfesor;
	
	// Mostrar Profesores:
	@Override
	@Transactional(readOnly = true)
	public List<Profesor> findAll() {
		return (List<Profesor>) repositorioProfesor.findAll();
	}
	
	// Buscar Profesor:
	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Long id) {
		return repositorioProfesor.findById(id).orElse(null);
	}
	
	// Guardar Profesor:
	@Override
	@Transactional
	public Profesor save(Profesor profesor) {
		return repositorioProfesor.save(profesor);
	}
	
	// Mostrar Distritos:
	@Override
	@Transactional(readOnly = true)
	public List<Especialidad> findAllEspecialidades() {
		return repositorioProfesor.findAllEspecialidades();
	}

}
