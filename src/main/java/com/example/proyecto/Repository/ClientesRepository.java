package com.example.proyecto.Repository;
import com.example.proyecto.pfinal.Model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
