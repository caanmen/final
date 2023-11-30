package com.example.proyecto.pfinal.Model;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "Clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteID;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 100)
    private String correoElectronico;

    @Column(length = 255)
    private String direccion;

    @Column
    private LocalDateTime fechaUltimaOrden;

    @Column
    private LocalDateTime fechaUltimaActualizacionDatos;

    // Getters y setters

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFechaUltimaOrden() {
        return fechaUltimaOrden;
    }

    public void setFechaUltimaOrden(LocalDateTime fechaUltimaOrden) {
        this.fechaUltimaOrden = fechaUltimaOrden;
    }

    public LocalDateTime getFechaUltimaActualizacionDatos() {
        return fechaUltimaActualizacionDatos;
    }

    public void setFechaUltimaActualizacionDatos(LocalDateTime fechaUltimaActualizacionDatos) {
        this.fechaUltimaActualizacionDatos = fechaUltimaActualizacionDatos;
    }
}
