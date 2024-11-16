package com.crudexample.crud.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crudexample.crud.Models.Editorial;
import com.crudexample.crud.Services.EditorialService;

import jakarta.validation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class mainController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/editoriales")
    public List<Editorial> getLenguajes() {
        return editorialService.getAllEditoriales();
    }

    @PostMapping("/postEditorial")
    public ResponseEntity<String> postMethodName(@Valid @RequestBody Editorial editorial) {
        return ResponseEntity.ok(editorialService.saveEditorial(editorial));
    }

}
