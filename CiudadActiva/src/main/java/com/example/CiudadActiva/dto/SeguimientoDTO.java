package com.example.CiudadActiva.dto;

import com.example.CiudadActiva.model.EstadoReporte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SeguimientoDTO(
        @NotNull
        Long usuarioId,

        @NotBlank @Size(max = 1000)
        String descripcion,

        EstadoReporte estadoNuevo
) {
}