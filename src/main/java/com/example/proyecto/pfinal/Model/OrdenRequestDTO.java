package com.example.proyecto.pfinal.Model;

import java.util.List;

public class OrdeneRequest {
    // Atributos como id del cliente, lista de productos, etc.
    private Long clienteId;
    private List<DetallesOrdenRequest> detalles;

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<DetalleOrdenRequest> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleOrdenRequest> detalles) {
        this.detalles = detalles;
    }
}
