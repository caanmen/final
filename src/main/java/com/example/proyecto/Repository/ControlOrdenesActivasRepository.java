package com.example.proyecto.Repository;
import com.example.proyecto.pfinal.Model.ControlOrdenesActivas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlOrdenesActivasRepository extends JpaRepository<ControlOrdenesActivas, Long> {
}
