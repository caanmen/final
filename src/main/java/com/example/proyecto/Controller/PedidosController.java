package com.example.proyecto.Controller;

import com.example.proyecto.Service.ClienteService;
import com.example.proyecto.Service.EmailService;
import com.example.proyecto.Service.PedidoServices;
import com.example.proyecto.pfinal.Model.OrdenDTO;
import com.example.proyecto.pfinal.Model.Ordenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {
    @Autowired
    private PedidoServices pedidoServics;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/ordenar")
    public ResponseEntity<?> realizarOrden(@RequestBody OrdenDTO ordenDTO) {
        // Implementar la lógica
        return new ResponseEntity<>("Se ha registrado su orden", HttpStatus.CREATED);
    }

    @PostMapping("/confirmar/{ordenId}")
    public ResponseEntity<?> confirmarOrden(@PathVariable Long ordenId) {
        // Implementar la lógica
        return new ResponseEntity<>("Confirmación de orden enviada", HttpStatus.OK);
    }
    @PostMapping("/orden")
    public ResponseEntity<?> crearOrden(@RequestBody OrdenRequest ordenRequest) {
        Ordenes ordenes = PedidoServices.crearOrden(ordenRequest);
        return ResponseEntity.ok(ordenes);
    }


    @GetMapping("/descuento/{clienteId}")
    public ResponseEntity<?> aplicarDescuento(@PathVariable Long clienteId) {
        // Implementar la lógica
        return new ResponseEntity<>("Descuento aplicado", HttpStatus.OK);
    }

    @PostMapping("/ordenSimultanea")
    public ResponseEntity<?> verificarOrdenSimultanea(@RequestBody OrdenDTO ordenDTO) {
        // Implementar la lógica
        return new ResponseEntity<>("Orden procesada", HttpStatus.CREATED);
    }
}
