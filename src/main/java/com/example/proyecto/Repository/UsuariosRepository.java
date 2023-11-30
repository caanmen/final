package com.example.proyecto.Repository;

import com.example.proyecto.pfinal.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    // Aquí puedes agregar métodos personalizados, si es necesario
}
