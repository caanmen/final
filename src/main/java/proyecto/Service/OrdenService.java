package proyecto.Service;

import proyecto.Modelo.Cliente;
import proyecto.Modelo.DetalleOrden;
import proyecto.Modelo.Orden;
import proyecto.Modelo.Producto;
import proyecto.Repository.ClienteRepository;
import proyecto.Repository.DetalleOrdenRepository;
import proyecto.Repository.OrdenRepository;
import proyecto.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Service
@RestController
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Transactional
    public Orden crearOrden(Long clienteId, List<DetalleOrden> detalles) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Orden orden = new Orden();
        orden.setCliente(cliente);
        orden.setFecha(new Date());
        orden.setEstado("pendiente");
        orden = ordenRepository.save(orden);

        for (DetalleOrden detalle : detalles) {
            Producto producto = productoRepository.findById(detalle.getProducto().getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            detalle.setOrden(orden);
            detalle.setProducto(producto);
            detalleOrdenRepository.save(detalle);
        }

        return orden;
    }
}
