package proyecto.Repository;

import proyecto.Modelo.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    // Métodos de consulta personalizados, por ejemplo, buscar órdenes de un cliente
    List<Orden> findByClienteId(Long clienteId);
}
