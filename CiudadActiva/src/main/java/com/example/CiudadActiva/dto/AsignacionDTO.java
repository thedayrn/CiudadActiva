package com.example.CiudadActiva.dto;

import jakarta.validation.constraints.NotNull;

public record AsignacionDTO(
        @NotNull Long gestorId,
        @NotNull Long operadorId
) {
}