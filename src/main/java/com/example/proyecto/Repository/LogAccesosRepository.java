package com.example.proyecto.Repository;

import com.example.proyecto.pfinal.Model.Logaccesos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogAccesosRepository extends JpaRepository<Logaccesos, Long> {
    // Métodos personalizados, si es necesario
}
