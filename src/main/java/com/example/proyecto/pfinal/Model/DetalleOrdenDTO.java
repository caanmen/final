package com.example.proyecto.pfinal.Model;

public class DetalleOrdenDTO {

    private Long productoId;
    private int cantidad;
    // Otros campos según sea necesario


    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}