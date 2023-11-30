package com.example.proyecto.Repository;
import com.example.proyecto.pfinal.Model.HistorialPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HistorialPedidosRepository extends JpaRepository<HistorialPedidos, Long>{
}
