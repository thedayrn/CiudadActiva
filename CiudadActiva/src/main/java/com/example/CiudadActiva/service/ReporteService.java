package com.example.CiudadActiva.service;

import com.example.CiudadActiva.dto.ReporteCreateDTO;
import com.example.CiudadActiva.dto.ReporteResponseDTO;

import java.util.List;

public interface ReporteService {
    ReporteResponseDTO crear(ReporteCreateDTO dto);
    List<ReporteResponseDTO> listar();
}