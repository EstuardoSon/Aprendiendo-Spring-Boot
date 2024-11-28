package com.crudexample.crud.Services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crudexample.crud.Models.Editorial;
import com.crudexample.crud.Repositories.EditorialRepository;

@SpringBootTest
public class EditorialServiceTest {

    private static Logger log = LoggerFactory.getLogger(EditorialServiceTest.class);

    @Autowired
    private EditorialService editorialService;

    @MockBean
    private EditorialRepository editorialRepository;

    Editorial testEditorial;

    @BeforeEach
    public void setUp() {
        Mockito.when(editorialRepository.findAll()).thenReturn(Collections.singletonList(
            Editorial.builder().id(0)
            .nombre("Editorial 0")
            .direccion("Direccion 0")
            .telefono("123456789")
            .email("editorial@gmail.com").build()));

        testEditorial = Editorial.builder().id(null)
            .nombre("Editorial 1")
            .direccion("Direccion 1")
            .telefono("123456789")
            .email("editorial@gmail.com").build();
    }

    @Test
    public void testGetAllEditoriales() {
        List<Editorial> editoriales = editorialService.getAllEditoriales();
        log.info(editoriales.toString());
        Assertions.assertNotNull(editoriales);
    }

    @Test
    public void testSaveEditorial() {
        Mockito.when(editorialRepository.save(testEditorial)).thenReturn(testEditorial);
        Assertions.assertEquals(editorialService.saveEditorial(testEditorial), "Editorial guardado");
    }

    @Test
    public void testFailSaveEditorial() {
        testEditorial.setId(0);
        log.info(testEditorial.toString());
        Mockito.when(editorialRepository.existsById(0)).thenReturn(true);
        Assertions.assertEquals(editorialService.saveEditorial(testEditorial), "Editorial ya existe");
    }
}
