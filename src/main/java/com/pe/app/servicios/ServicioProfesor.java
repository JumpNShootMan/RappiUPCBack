package com.pe.app.servicios;

import java.util.List;

import com.pe.app.entidades.Especialidad;
import com.pe.app.entidades.Profesor;

public interface ServicioProfesor {
	
	public List<Profesor> findAll();
	
	//public Page<Cliente> findAll(Pageable pageable);
	
	public Profesor findById(Long id);
	
	public Profesor save(Profesor profesor);
	
	public List<Especialidad> findAllEspecialidades();

}
