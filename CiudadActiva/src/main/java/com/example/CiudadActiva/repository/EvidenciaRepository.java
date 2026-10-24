package com.example.CiudadActiva.repository;

import com.example.CiudadActiva.model.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvidenciaRepository extends JpaRepository<Evidencia, Long> {
    List<Evidencia> findByReporteId(Long reporteId);
}
