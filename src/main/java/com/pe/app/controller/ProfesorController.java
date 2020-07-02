package com.pe.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.app.entidades.Profesor;
import com.pe.app.servicios.ServicioProfesor;

@RestController
@RequestMapping("/api")
public class ProfesorController {

	@Autowired
	private ServicioProfesor servicioProfesor;
	
	// Mostrar Todos los Profesores:
	@GetMapping("/Profesores")
	public List<Profesor> index() {
		return servicioProfesor.findAll();
	}
	
	// Buscar Estudiante Id:
	@GetMapping("/Profesores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Profesor profesor = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			profesor = servicioProfesor.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(profesor == null) {
			response.put("mensaje", "El profesor ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
	}
	
	// Crear Estudiante:
	@PostMapping("/Profesores")
	public ResponseEntity<?> create(@Valid @RequestBody Profesor profesor, BindingResult result) {
		
		Profesor profesorNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			profesorNew = servicioProfesor.save(profesor);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El profesor ha sido creado con éxito!");
		response.put("profesor", profesorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
