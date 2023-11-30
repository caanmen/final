package com.example.proyecto.pfinal.Model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ControlOrdenesActivas")
public class ControlOrdenesActivas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long controlID;

    @ManyToOne
    @JoinColumn(name = "ClienteID", nullable = false)
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "OrdenActivaID", nullable = false)
    private Ordenes ordenActiva;

    @Column(nullable = false)
    private LocalDateTime fechaInicioOrden;

    @Column
    private LocalDateTime fechaEstimadaEntrega;

    // Getters y setters

    public Long getControlID() {
        return controlID;
    }

    public void setControlID(Long controlID) {
        this.controlID = controlID;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setCliente(Clientes clientes) {
        this.clientes = clientes;
    }

    public Ordenes getOrdenesActiva() {
        return ordenActiva;
    }

    public void setOrdenActiva(Ordenes ordenActiva) {
        this.ordenActiva = ordenActiva;
    }

    public LocalDateTime getFechaInicioOrden() {
        return fechaInicioOrden;
    }

    public void setFechaInicioOrden(LocalDateTime fechaInicioOrden) {
        this.fechaInicioOrden = fechaInicioOrden;
    }

    public LocalDateTime getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDateTime fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }
}
