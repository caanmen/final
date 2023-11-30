package com.example.proyecto.Repository;
import com.example.proyecto.pfinal.Model.Descuentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DescuentosRepository extends JpaRepository<Descuentos, Long> {
}
