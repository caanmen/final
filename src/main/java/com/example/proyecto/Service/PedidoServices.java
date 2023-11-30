package com.example.proyecto.Service;

import com.example.proyecto.Repository.*;
import com.example.proyecto.pfinal.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServices {
    @Autowired
    private OrdenesRepository ordenRepository;


    public Ordenes crearOrden(OrdenDTO ordenDTO) {
        // Implementar la lógica para crear una orden
        return new Ordenes(); // Cambiar según la implementación
    }
    public Ordenes crearOrden(OrdenesRequest ordenRequest) {
        if (controlOrdenesActivasRepository.existeOrdenActiva(ordenRequest.getClienteId())) {
            throw new OrdenActivaException("El cliente ya tiene una orden activa.");
        }

    public Ordenes obtenerOrden(Long ordenId) {
        // Implementar la lógica para obtener una orden
        return new Ordenes(); // Cambiar según la implementación
    }

    public boolean esClienteFiel(Clientes clientes) {
        // Implementar la lógica para verificar si un cliente es fiel
        return true; // Cambiar según la implementación
    }

    public Ordenes aplicarDescuentoSiEsNecesario(Ordenes ordenes) {
        long count = HistorialPedidosRepository.countPedidosRecientes(ordenes.getCliente().getId());
        if (count > 5) {
            // Aplicar descuento
        }
        return ordenes;
    }

    public boolean existeOrdenActiva(Long clienteId) {
        // Implementar la lógica para verificar órdenes activas
        return false; // Cambiar según la implementación
    }
    public Ordenes crearOrden(OrdenesRequest ordenRequest) {
        Clientes clientes = ClientesRepository.findById(ordenRequest.getClientesId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Ordenes nuevaOrden = new Ordenes();
        nuevaOrden.setCliente(clientes);
        nuevaOrden.setFechaOrden(LocalDateTime.now());
        nuevaOrden.setEstado("Pendiente");
        // Otros atributos de la orden...

        Ordenes ordenGuardada = OrdenesRepository.save(nuevaOrden);

        List<DetallesOrden> detallesOrden = ordenRequest.getDetalles().stream().map(detalle -> {
            Productos productos = ProductosRepository.findById(detalle.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            DetallesOrden detalleOrden = new DetallesOrden();
            detalleOrden.setOrden(ordenGuardada);
            detalleOrden.setProducto(productos);
            detalleOrden.setCantidad(detalle.getCantidad());
            detalleOrden.setSubtotal(productos.getPrecio().multiply(new BigDecimal(detalle.getCantidad())));
            // Otros atributos del detalle...

            return detalleOrden;
        }).collect(Collectors.toList());

        DetallesOrdenRepository.saveAll(detallesOrden);

        return ordenGuardada;
    }

}
