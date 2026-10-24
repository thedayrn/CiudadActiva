package com.example.CiudadActiva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "seguimientos")
public class Seguimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reporte_id", updatable = false)
    private Reporte reporte;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", updatable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 1000, updatable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private EstadoReporte estadoNuevo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    // Constructor vacío (obligatorio para JPA)
    public Seguimiento() {
    }

    public Seguimiento(Reporte reporte, Usuario usuario, String descripcion, EstadoReporte estadoNuevo) {
        this.reporte = reporte;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.estadoNuevo = estadoNuevo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoReporte getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(EstadoReporte estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}