package com.example.proyecto.pfinal.Model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "AplicacionDescuentos")
public class AplicacionDescuentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aplicacionID;

    @ManyToOne
    @JoinColumn(name = "DescuentoID", nullable = false)
    private Descuentos descuentos;

    @ManyToOne
    @JoinColumn(name = "OrdenID", nullable = false)
    private Ordenes ordenes;

    @Column(nullable = false)
    private LocalDateTime fechaAplicacion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montoDescuento;

    // Getters y setters

    public Long getAplicacionID() {
        return aplicacionID;
    }

    public void setAplicacionID(Long aplicacionID) {
        this.aplicacionID = aplicacionID;
    }

    public Descuentos getDescuentos() {
        return descuentos;
    }

    public void setDescuento(Descuentos descuentos) {
        this.descuentos = descuentos;
    }

    public Ordenes getOrdenes() {
        return ordenes;
    }

    public void setOrden(Ordenes ordenes) {
        this.ordenes = ordenes;
    }

    public LocalDateTime getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(LocalDateTime fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public BigDecimal getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(BigDecimal montoDescuento) {
        this.montoDescuento = montoDescuento;
    }
}
