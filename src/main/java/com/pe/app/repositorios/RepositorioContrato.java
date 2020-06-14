package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.app.entidades.Contrato;

public interface RepositorioContrato extends JpaRepository<Contrato, Long> {

}
