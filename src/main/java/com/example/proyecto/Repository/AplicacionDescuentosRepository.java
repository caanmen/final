package com.example.proyecto.Repository;
import com.example.proyecto.pfinal.Model.AplicacionDescuentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AplicacionDescuentosRepository extends JpaRepository<AplicacionDescuentos, Long> {
}
