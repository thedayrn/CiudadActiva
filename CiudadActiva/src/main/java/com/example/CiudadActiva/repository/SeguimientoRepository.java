package com.example.CiudadActiva.repository;

import com.example.CiudadActiva.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {
    List<Seguimiento> findByReporteIdOrderByFechaAsc(Long reporteId);
}