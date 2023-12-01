package proyecto.Controller;

import proyecto.Modelo.Orden;
import proyecto.Service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<Orden> crearOrden(@RequestBody Orden orden) {
        if (orden.getCliente() == null || orden.getCliente().getId() == null) {
            // Manejar el caso de cliente nulo o id de cliente nulo
            return ResponseEntity.badRequest().body(null); // o alguna otra respuesta adecuada
        }

        Orden nuevaOrden = ordenService.crearOrden(orden.getCliente().getId(), orden.getDetallesOrden());
        return ResponseEntity.ok(nuevaOrden);


    }


    // Aquí puedes agregar más endpoints para otras operaciones con órdenes
}
