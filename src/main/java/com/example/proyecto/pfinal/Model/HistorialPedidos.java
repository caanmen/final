package com.example.proyecto.pfinal.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "HistorialPedidos")
public class HistorialPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historialID;

    @ManyToOne
    @JoinColumn(name = "ClienteID", nullable = false)
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "OrdenID", nullable = false)
    private Ordenes ordenes;

    @Column(nullable = false)
    private LocalDateTime fechaPedido;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPedido;

    // Getters y setters

    public Long getHistorialID() {
        return historialID;
    }

    public void setHistorialID(Long historialID) {
        this.historialID = historialID;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setCliente(Clientes clientes) {
        this.clientes = clientes;
    }

    public Ordenes getOrdens() {
        return ordenes;
    }

    public void setOrden(Ordenes ordenes) {
        this.ordenes = ordenes;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }
}
