package com.crudexample.crud.Repositories;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.crudexample.crud.Models.Editorial;

import jakarta.validation.ConstraintViolationException;

@DataJpaTest
public class EditorialRepositoryTest {

    private static Logger log = LoggerFactory.getLogger(EditorialRepositoryTest.class);

    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Editorial editorial;

    @BeforeEach
    public void setUp() {
        editorial = Editorial.builder()
                .nombre("Editorial 0")
                .direccion("Direccion 0")
                .telefono("123456789")
                .email("editorial@gmail.com").build();

        entityManager.persist(editorial);
    }

    @Test
    public void testFindAllEditoriales() {
        List<Editorial> editoriales = editorialRepository.findAll();
        log.info("Editoriales: " + editoriales);
        Assertions.assertNotNull(editoriales);
    }

    @Test
    public void testSaveEditorial() {
        Editorial newEditorial = Editorial.builder()
                .nombre("Editorial 1")
                .direccion("Direccion 1")
                .telefono("123456789")
                .email("editorial@gmail.com").build();

        editorialRepository.save(newEditorial);
        Assertions.assertNotNull(editorialRepository.findById(newEditorial.getId()));
    }

    @Test
    public void testFailSaveEditorial() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Editorial editorialTest = Editorial.builder().id(null).nombre(null).build();
            editorialRepository.save(editorialTest);
        });
    }
}
