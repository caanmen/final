package com.example.proyecto.Repository;
import com.example.proyecto.pfinal.Model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
