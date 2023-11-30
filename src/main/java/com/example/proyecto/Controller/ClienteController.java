package com.example.proyecto.Controller;

import com.example.proyecto.Service.ClienteService;
import com.example.proyecto.pfinal.Model.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarDatosCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.actualizarDatosCliente(clienteDTO);
        return new ResponseEntity<>("Datos del cliente actualizados", HttpStatus.OK);
    }
}
