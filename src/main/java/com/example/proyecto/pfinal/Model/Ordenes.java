package com.example.proyecto.pfinal.Model;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Ordenes")
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordenID;

    @ManyToOne
    @JoinColumn(name = "ClienteID", nullable = false)
    private Clientes clientes;

    @Column(nullable = false)
    private LocalDateTime fechaOrden;

    @Column(nullable = false, length = 50)
    private String estado;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "orden")
    private Set<DetallesOrden> detallesOrden;

    // Getters y setters

    public Long getOrdenID() {
        return ordenID;
    }

    public void setOrdenID(Long ordenID) {
        this.ordenID = ordenID;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setCliente(Clientes clientes) {
        this.clientes = clientes;
    }

    public LocalDateTime getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDateTime fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Set<DetallesOrden> getDetallesOrden() {
        return detallesOrden;
    }

    public void setDetallesOrden(Set<DetallesOrden> detallesOrden) {
        this.detallesOrden = detallesOrden;
    }
}
