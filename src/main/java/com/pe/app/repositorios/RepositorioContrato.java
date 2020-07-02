package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.app.entidades.Contrato;

public interface RepositorioContrato extends JpaRepository<Contrato, Long> {
	@Query("SELECT c FROM Contrato c WHERE c.idContrato=:idContrato")
	Contrato obtener(@Param("idContrato") Long idContrato);
	

}
