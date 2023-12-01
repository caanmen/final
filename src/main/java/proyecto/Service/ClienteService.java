package proyecto.Service;

import proyecto.Modelo.Cliente;
import proyecto.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente buscarClientePorCorreo(String correo) {
        return clienteRepository.findByCorreoElectronico(correo);
    }

    // Otros métodos relacionados con clientes
}
