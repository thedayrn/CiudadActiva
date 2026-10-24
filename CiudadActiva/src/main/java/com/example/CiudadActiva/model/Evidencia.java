package com.example.CiudadActiva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "evidencias")
public class Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url; // ruta o enlace de la foto/archivo

    private String tipo; // IMAGEN, VIDEO, DOCUMENTO

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reporte_id")
    private Reporte reporte;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaSubida = LocalDateTime.now();

    // Constructor vacío (obligatorio para JPA)
    public Evidencia() {
    }

    public Evidencia(String url, String tipo, Reporte reporte) {
        this.url = url;
        this.tipo = tipo;
        this.reporte = reporte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public LocalDateTime getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDateTime fechaSubida) {
        this.fechaSubida = fechaSubida;
    }
}