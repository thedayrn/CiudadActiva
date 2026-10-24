package com.example.CiudadActiva.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReporteCreateDTO(
        @NotBlank @Size(max = 150)
        String titulo,

        @NotBlank @Size(max = 1000)
        String descripcion,

        @NotNull
        Long categoriaId,

        @NotNull
        Long ciudadanoId, // temporal: con JWT saldrá del token

        @NotNull @Valid
        UbicacionDTO ubicacion
) {
}