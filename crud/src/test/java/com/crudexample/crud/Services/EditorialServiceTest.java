package com.crudexample.crud.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crudexample.crud.Repositories.EditorialRepository;

@SpringBootTest
public class EditorialServiceTest {

    @Autowired
    private EditorialService editorialService;

    @MockBean
    private EditorialRepository editorialRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testGetAllEditoriales() {
        Assertions.assertNotNull(editorialService.getAllEditoriales());
    }
}
