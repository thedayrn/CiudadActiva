package com.example.CiudadActiva.repository;

import com.example.CiudadActiva.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    List<Asignacion> findByOperadorId(Long operadorId);
}