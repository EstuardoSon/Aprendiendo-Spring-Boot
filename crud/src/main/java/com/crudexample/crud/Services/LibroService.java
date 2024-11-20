package com.crudexample.crud.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crudexample.crud.Models.Libro;
import com.crudexample.crud.Repositories.LibroRepository;

@Service
public class LibroService {

    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getLibros() {
        return (List<Libro>) libroRepository.findAll();
    }

}
