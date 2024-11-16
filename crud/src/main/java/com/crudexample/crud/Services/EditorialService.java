package com.crudexample.crud.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudexample.crud.Models.Editorial;
import com.crudexample.crud.Repositories.EditorialRepository;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editorial> getAllEditoriales() {
        return (List<Editorial>) editorialRepository.findAll();
    }

    public String saveEditorial(Editorial editorial) {
        if (editorial.getId() == null) {
            editorialRepository.save(editorial);
            return "Editorial guardado";
        } else {
            if (editorialRepository.existsById(editorial.getId())) {
                return "Editorial ya existe";
            }
            throw new IllegalArgumentException("Bad Request");
        }

    }
}
