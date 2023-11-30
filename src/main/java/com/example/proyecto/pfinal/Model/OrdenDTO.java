package com.example.proyecto.pfinal.Model;

import java.util.List;

public class OrdenDTO {

    private Long clienteId;
    private List<DetalleOrdenDTO> detalles;
    // Otros campos según sea necesario

    // Getters y setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<DetalleOrdenDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrdenDTO> detalles) {
        this.detalles = detalles;
    }
}