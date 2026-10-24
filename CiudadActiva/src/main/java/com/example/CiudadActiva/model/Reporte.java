package com.example.CiudadActiva.model;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReporte estado = EstadoReporte.PENDIENTE;

    @Enumerated(EnumType.STRING)
    private PrioridadReporte prioridad;

    private String motivoRechazo; // obligatorio si el estado es RECHAZADO

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ciudadano_id")
    private Usuario ciudadano;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id")
    private CategoriaIncidencia categoria;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Constructor vacío (obligatorio para JPA)
    public Reporte() {
    }

    public Reporte(String titulo, String descripcion, Usuario ciudadano,
                   CategoriaIncidencia categoria, Ubicacion ubicacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ciudadano = ciudadano;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoReporte getEstado() {
        return estado;
    }

    public void setEstado(EstadoReporte estado) {
        this.estado = estado;
    }

    public PrioridadReporte getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadReporte prioridad) {
        this.prioridad = prioridad;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public Usuario getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Usuario ciudadano) {
        this.ciudadano = ciudadano;
    }

    public CategoriaIncidencia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaIncidencia categoria) {
        this.categoria = categoria;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}