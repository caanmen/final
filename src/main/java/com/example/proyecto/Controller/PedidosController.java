package com.example.proyecto.Controller;

import com.example.proyecto.Service.PedidoService;
import com.example.proyecto.Service.PedidoServices;
import com.example.proyecto.pfinal.Model.OrdenRequest;
import com.example.proyecto.pfinal.Model.Ordenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidoServices pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearOrden(@RequestBody OrdenRequest ordenRequest) {
        try {
            Ordenes orden = pedidoService.crearOrden(ordenRequest);
            return new ResponseEntity<>(orden, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/confirmar/{ordenId}")
    public ResponseEntity<?> confirmarOrden(@PathVariable Long ordenId) {
        try {
            pedidoService.confirmarOrden(ordenId);
            return new ResponseEntity<>("Orden confirmada y correo enviado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Otros métodos relacionados con pedidos pueden ser añadidos aquí
}
