package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.app.entidades.Servicio;

public interface RepositorioServicio extends JpaRepository<Servicio, Long> {
	@Query("SELECT s FROM Servicio s WHERE s.idServicio=:idServicio")
	Servicio obtener(@Param("idServicio") Long idServicio);
}
