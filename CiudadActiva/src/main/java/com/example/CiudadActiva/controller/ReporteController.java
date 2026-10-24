package com.example.CiudadActiva.controller;

import com.example.CiudadActiva.dto.ReporteCreateDTO;
import com.example.CiudadActiva.dto.ReporteResponseDTO;
import com.example.CiudadActiva.service.ReporteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @PostMapping
    public ResponseEntity<ReporteResponseDTO> crear(@Valid @RequestBody ReporteCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reporteService.crear(dto));
    }

    @GetMapping
    public List<ReporteResponseDTO> listar() {
        return reporteService.listar();
    }
}