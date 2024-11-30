package com.crudexample.crud.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crudexample.crud.Models.Editorial;
import com.crudexample.crud.Services.EditorialService;

import jakarta.validation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
public class mainController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/editoriales")
    public List<Editorial> getEditoriales() {
        return editorialService.getAllEditoriales();
    }

    @PostMapping("/postEditorial")
    public ResponseEntity<String> postEditorial(@Valid @RequestBody Editorial editorial) {
        return ResponseEntity.ok(editorialService.saveEditorial(editorial));
    }

    @DeleteMapping("/deleteEditorial")
    public ResponseEntity<String> deleteEditorial(@RequestParam int editorial) {
        return ResponseEntity.ok(editorialService.deleteEditorial(editorial));
    }

    @PutMapping("/updateEditorial")
    public ResponseEntity<String> updateEditorial(@Valid @RequestBody Editorial editorial) {
        return ResponseEntity.ok(editorialService.updateEditorial(editorial));
    }
}
