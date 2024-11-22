package com.crudexample.crud.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudexample.crud.Models.Editorial;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    @SuppressWarnings("null")
    public List<Editorial> findAll();

    public Optional<Editorial> findById(int id);
}
