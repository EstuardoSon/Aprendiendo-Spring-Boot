package com.crudexample.crud.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Libros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Integer idLibro;
    
    private String titulo;
    private String autor;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion; 
    
    private String isbn;
    
    @ManyToOne(targetEntity = Editorial.class)
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
    
    private Float precio;
}
