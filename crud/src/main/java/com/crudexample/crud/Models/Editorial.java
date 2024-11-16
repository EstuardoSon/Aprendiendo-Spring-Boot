package com.crudexample.crud.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Editoriales")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private Integer id;
    
    @NotNull(message = "Nombre may not be null")
    @NotBlank(message = "Nombre is required")
    private String nombre;

    @NotNull(message = "Direccion may not be null")
    @NotBlank(message = "Direccion is required")
    private String direccion;

    @NotNull(message = "Telefono may not be null")
    @NotBlank(message = "Telefono is required")
    private String telefono;

    @NotNull(message = "Email may not be null") 
    @NotBlank(message = "Email is required")
    private String email;

    public Editorial(){}

    public Editorial(Integer id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
