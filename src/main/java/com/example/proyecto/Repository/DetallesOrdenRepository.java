package com.example.proyecto.Repository;
import com.example.proyecto.pfinal.Model.DetallesOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesOrdenRepository extends JpaRepository<DetallesOrden, Long> {
}
