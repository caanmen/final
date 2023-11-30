package com.example.proyecto.Repository;

import com.example.proyecto.pfinal.Model.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {

}
