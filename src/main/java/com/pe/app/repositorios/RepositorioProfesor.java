package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.app.entidades.Profesor;

public interface RepositorioProfesor extends JpaRepository<Profesor, Long> {
    @Query("SELECT p FROM Profesor p WHERE p.idProfesor=:idProfesor")
    Profesor obtenerId(@Param("idProfesor") Long idProfesor);

    @Query("SELECT p FROM Profesor p WHERE p.dniProfesor=:dniProfesor")
    Profesor obtenerDni(@Param("dniProfesor") String dniProfesor);
}
