package com.example.proyecto.Service;

import com.example.proyecto.Repository.*;
import com.example.proyecto.pfinal.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClientesRepository clienteRepository;

    @Autowired
    private ProductosRepository productoRepository;

    @Autowired
    private EmailService emailService;

    // Otros repositorios si son necesarios

    public Ordenes crearOrden(OrdenesRequest ordenRequest) {
        // Verificar si el cliente tiene una orden activa
        if (existeOrdenActiva(ordenRequest.getClienteId())) {
            throw new RuntimeException("El cliente ya tiene una orden activa.");
        }

        // Obtener cliente
        Clientes cliente = clienteRepository.findById(ordenRequest.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Crear la orden
        Ordenes nuevaOrden = new Ordenes();
        nuevaOrden.setCliente(cliente);
        nuevaOrden.setFechaOrden(LocalDateTime.now());
        nuevaOrden.setEstado("Pendiente");
        // ...

        // Guardar la orden
        Ordenes ordenGuardada = pedidoRepository.save(nuevaOrden);

        // Crear y guardar detalles de la orden
        BigDecimal totalOrden = BigDecimal.ZERO;
        for (DetalleOrdenRequest detalleRequest : ordenRequest.getDetalles()) {
            Producto producto = productoRepository.findById(detalleRequest.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            DetalleOrden detalleOrden = new DetalleOrden();
            detalleOrden.setOrden(ordenGuardada);
            detalleOrden.setProducto(producto);
            detalleOrden.setCantidad(detalleRequest.getCantidad());
            BigDecimal subtotal = producto.getPrecio().multiply(new BigDecimal(detalleRequest.getCantidad()));
            detalleOrden.setSubtotal(subtotal);
            totalOrden = totalOrden.add(subtotal);

            // Guardar detalle de la orden
            // detalleOrdenRepository.save(detalleOrden);
        }

        // Actualizar el total de la orden
        ordenGuardada.setTotal(totalOrden);

        // Aplicar descuento si es necesario
        aplicarDescuentoSiEsNecesario(ordenGuardada);

        return ordenGuardada;
    }

    public void confirmarOrden(Long ordenId) {
        Ordenes orden = pedidoRepository.findById(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        // Confirmar la orden y enviar correo
        emailService.enviarEmailConfirmacion(orden);
        orden.setEstado("Confirmada");
        pedidoRepository.save(orden);
    }

    private boolean existeOrdenActiva(Long clienteId) {
        // Implementar lógica para verificar si existe una orden activa
        List<Ordenes> ordenesActivas = pedidoRepository.findOrdenesActivasByClienteId(clienteId);
        return !ordenesActivas.isEmpty();
    }

    private void aplicarDescuentoSiEsNecesario(Ordenes orden) {
        // Implementar lógica para aplicar descuentos
        int cantidadPedidos = pedidoRepository.contarPedidosUltimosDosMeses(orden.getCliente().getId());
        if (cantidadPedidos > 5) {
            BigDecimal descuento = orden.getTotal().multiply(new BigDecimal("0.10"));
            orden.setTotal(orden.getTotal().subtract(descuento));
            pedidoRepository.save(orden);
        }
    }

    // Otros métodos necesarios para el servicio
}
