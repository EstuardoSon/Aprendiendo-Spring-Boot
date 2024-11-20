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
        if (editorialRepository.existsById(editorial.getId())) {
            return "Editorial ya existe";
        }
        editorialRepository.save(editorial);
        return "Editorial guardado";
    }

    public String deleteEditorial(int idEditorial) {
        if (editorialRepository.existsById(idEditorial)) {
            editorialRepository.deleteById(idEditorial);
            return "Editorial eliminado";
        }
        throw new IllegalArgumentException("Editorial no existe");
    }

    public String updateEditorial(Editorial editorial) {
        if (editorialRepository.existsById(editorial.getId())) {
            editorialRepository.save(editorial);
            return "Editorial actualizado";
        }
        throw new IllegalArgumentException("Editorial no existe");
    }
}
