package com.example.proyecto.Controller;

import com.example.proyecto.Service.UsuarioService;
import com.example.proyecto.pfinal.Model.Credenciales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestBody Credenciales credenciales) {
        boolean autenticado = usuarioService.autenticar(credenciales);
        if (!autenticado) {
            return new ResponseEntity<>("Usuario no autenticado", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Autenticación exitosa", HttpStatus.OK);
    }
}
