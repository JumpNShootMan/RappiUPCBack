package com.pe.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.app.entidades.Distrito;

public interface RepositorioDistrito extends JpaRepository<Distrito, Long> {
    @Query("SELECT d FROM Distrito d WHERE d.idDistrito=:idDistrito")
    Distrito obtenerDistrito(@Param("idDistrito") Long idDistrito);
}
