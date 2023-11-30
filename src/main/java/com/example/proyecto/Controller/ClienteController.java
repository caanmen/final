package com.example.proyecto.Controller;

import com.example.proyecto.Service.ClienteService;
import com.example.proyecto.pfinal.Model.ClienteDTO;
import com.example.proyecto.pfinal.Model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarDatosCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            clienteService.actualizarDatosCliente(clienteDTO);
            return new ResponseEntity<>("Datos del cliente actualizados", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable Long id, @RequestBody Clientes clienteActualizado) {
        try {
            Clientes cliente = clienteService.actualizarCliente(id, clienteActualizado);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Aquí puedes agregar otros métodos relacionados con las operaciones de clientes
}