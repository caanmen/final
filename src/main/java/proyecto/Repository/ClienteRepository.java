package proyecto.Repository;

import proyecto.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos de consulta personalizados, por ejemplo, buscar por correo electrónico
    Cliente findByCorreoElectronico(String correoElectronico);
}
