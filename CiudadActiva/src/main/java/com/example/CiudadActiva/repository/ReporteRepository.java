package com.example.CiudadActiva.repository;

import com.example.CiudadActiva.model.EstadoReporte;
import com.example.CiudadActiva.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    List<Reporte> findByEstado(EstadoReporte estado);

    List<Reporte> findByCategoriaId(Long categoriaId);
}