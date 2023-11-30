package com.example.proyecto.pfinal.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "DetallesOrden")
public class DetallesOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleID;

    @ManyToOne
    @JoinColumn(name = "OrdenID", nullable = false)
    private Ordenes ordenes;

    @ManyToOne
    @JoinColumn(name = "ProductoID", nullable = false)
    private Productos productos;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    // Getters y setters

    public Long getDetalleID() {
        return detalleID;
    }

    public void setDetalleID(Long detalleID) {
        this.detalleID = detalleID;
    }

    public Ordenes getOrdenes() {
        return getOrdenes();
    }

    public void setOrden(Ordenes ordenes) {
        this.ordenes = ordenes;
    }

    public Productos getProductos() {
        return getProductos();
    }

    public void setProducto(Productos productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
