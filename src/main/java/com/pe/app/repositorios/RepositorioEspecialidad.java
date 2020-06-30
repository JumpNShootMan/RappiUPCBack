package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.app.entidades.Especialidad;

public interface RepositorioEspecialidad extends JpaRepository<Especialidad, Long>{
	@Query("SELECT e FROM Especialidad e WHERE e.idEspecialidad=:idEspecialidad")
	Especialidad obtenerEspecialidad(@Param("idEspecialidad") Long idEspecialidad);
}
