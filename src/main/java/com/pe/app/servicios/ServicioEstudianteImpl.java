package com.pe.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.app.entidades.Distrito;
import com.pe.app.entidades.Estudiante;
import com.pe.app.repositorios.RepositorioEstudiante;

@Service
public class ServicioEstudianteImpl implements ServicioEstudiante{

	@Autowired
	private RepositorioEstudiante repositorioEstudiante;
	
	// Mostrar Estudiantes:
	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		return (List<Estudiante>) repositorioEstudiante.findAll();
	}
	
	// Buscar Estudiante:
	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Long id) {
		return repositorioEstudiante.findById(id).orElse(null);
	}
	
	// Guardar Estudiante:
	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		return repositorioEstudiante.save(estudiante);
	}
	
	// Mostrar Distritos:
	@Override
	@Transactional(readOnly = true)
	public List<Distrito> findAllDistritos() {
		return repositorioEstudiante.findAllDistritos();
	}
	
}
