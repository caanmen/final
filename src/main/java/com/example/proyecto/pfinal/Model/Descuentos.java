package com.example.proyecto.pfinal.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Descuentos")
public class Descuentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long descuentoID;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentajeDescuento;

    @Column(columnDefinition = "TEXT")
    private String condiciones;

    // Getters y setters

    public Long getDescuentoID() {
        return descuentoID;
    }

    public void setDescuentoID(Long descuentoID) {
        this.descuentoID = descuentoID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }
}
