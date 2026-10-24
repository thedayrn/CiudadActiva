package com.example.CiudadActiva.exception;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        LocalDateTime timestamp,
        int status,
        String message,
        String path
) {
}