package com.example.CiudadActiva.repository;

import com.example.CiudadActiva.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByReporteId(Long reporteId);
}