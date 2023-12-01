package proyecto.Repository;

import proyecto.Modelo.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {
    // Métodos de consulta personalizados, por ejemplo, buscar detalles por orden
    List<DetalleOrden> findByOrdenId(Long ordenId);
}
