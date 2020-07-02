package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.app.entidades.Contrato;

public interface RepositorioContrato extends JpaRepository<Contrato, Long> {
	@Query("SELECT c FROM Contrato c WHERE c.idContrato=:idContrato")
	Contrato obtener(@Param("idContrato") Long idContrato);
	
	//@Query("SELECT s.nom_servicio FROM Contrato c join Servicio s ON c.codigo_servicio = s.codigo_servicio")
	//Contrato setNomServicio(@Param("idContrato") Long idContrato);
	
}
