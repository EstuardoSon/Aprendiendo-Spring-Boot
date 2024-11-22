package com.crudexample.crud.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}
