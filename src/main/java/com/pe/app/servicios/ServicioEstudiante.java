package com.pe.app.servicios;

import java.util.List;

import com.pe.app.entidades.Distrito;
import com.pe.app.entidades.Estudiante;

public interface ServicioEstudiante {

	public List<Estudiante> findAll();
	
	//public Page<Cliente> findAll(Pageable pageable);
	
	public Estudiante findById(Long id);
	
	public Estudiante save(Estudiante estudiante);
	
	public List<Distrito> findAllDistritos();
}
