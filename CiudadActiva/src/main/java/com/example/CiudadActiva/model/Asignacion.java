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
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reporte_id")
    private Reporte reporte;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gestor_id")
    private Usuario gestor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operador_id")
    private Usuario operador;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaAsignacion = LocalDateTime.now();

    // Constructor vacío (obligatorio para JPA)
    public Asignacion() {
    }

    public Asignacion(Reporte reporte, Usuario gestor, Usuario operador) {
        this.reporte = reporte;
        this.gestor = gestor;
        this.operador = operador;
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

    public Usuario getGestor() {
        return gestor;
    }

    public void setGestor(Usuario gestor) {
        this.gestor = gestor;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
}