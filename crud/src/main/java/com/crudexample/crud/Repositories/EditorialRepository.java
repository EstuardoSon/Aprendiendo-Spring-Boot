package com.crudexample.crud.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudexample.crud.Models.Editorial;

@Repository
public interface EditorialRepository extends CrudRepository<Editorial, Integer>{
}
