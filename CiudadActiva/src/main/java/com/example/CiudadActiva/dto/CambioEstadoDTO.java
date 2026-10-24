package com.example.CiudadActiva.dto;

import com.example.CiudadActiva.model.EstadoReporte;
import com.example.CiudadActiva.model.PrioridadReporte;
import jakarta.validation.constraints.NotNull;

public record CambioEstadoDTO(
        @NotNull
        EstadoReporte estado,

        PrioridadReporte prioridad,  // al validar
        String motivoRechazo         // obligatorio si estado = RECHAZADO (lo valida el service)
) {
}