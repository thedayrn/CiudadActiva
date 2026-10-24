package com.example.CiudadActiva.dto;

import com.example.CiudadActiva.model.EstadoReporte;
import com.example.CiudadActiva.model.PrioridadReporte;

import java.time.LocalDateTime;

public record ReporteResponseDTO(
        Long id,
        String titulo,
        String descripcion,
        EstadoReporte estado,
        PrioridadReporte prioridad,
        String motivoRechazo,
        String ciudadanoNombre,
        String categoriaNombre,
        UbicacionDTO ubicacion,
        LocalDateTime fechaCreacion
) {
}