package com.crudexample.crud.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudexample.crud.Models.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer> {
}
