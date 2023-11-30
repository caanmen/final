package com.example.proyecto.Service;

import com.example.proyecto.Repository.UsuariosRepository;
import com.example.proyecto.pfinal.Model.Credenciales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public boolean autenticar(Credenciales credenciales) {
        // Implementar la lógica de autenticación
        return true; // Cambiar según la implementación
    }

    public boolean estaAutenticado(Long usuarioId) {
        // Implementar la verificación de autenticación
        return true; // Cambiar según la implementación
    }
}
