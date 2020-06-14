package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.app.entidades.Estudiante;

public interface RepositorioEstudiante extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE e.idEstudiante=:idEstudiante")
    Estudiante obtener(@Param("idEstudiante") Long idEstudiante);

    @Query("SELECT e FROM Estudiante e WHERE e.dniEstudiante=:dniEstudiante")
    Estudiante obtenerDni(@Param("dniEstudiante") String dniEstudiante);
}

