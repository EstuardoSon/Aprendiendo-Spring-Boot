package com.crudexample.crud.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crudexample.crud.Models.Libro;
import com.crudexample.crud.Services.LibroService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
public class libroController {
    private LibroService libroService;

    public libroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/libros")
    public List<Libro> getMethodName() {
        return libroService.getLibros();
    }
    
}
