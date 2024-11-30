package com.crudexample.crud.Controllers;

// VS code no logra importar las dependencias, agregarlas manualmente
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.crudexample.crud.Models.Editorial;
import com.crudexample.crud.Services.EditorialService;

@WebMvcTest(mainController.class)
public class mainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EditorialService editorialService;

    private Editorial editorial;

    @BeforeEach
    public void setUp() {
        editorial = Editorial.builder()
                .nombre("Editorial 0")
                .direccion("Direccion 0")
                .telefono("123456789")
                .email("editorial@gmail.com").build();
    }

    @Test
    void testGetEditoriales() throws Exception {
        Mockito.when(editorialService.getAllEditoriales()).thenReturn(Collections.singletonList(editorial));
        mockMvc.perform(get("/editoriales"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].nombre").value(editorial.getNombre()));
    }

    @Test
    void testSaveEditorial() throws Exception {
        Editorial newEditorial = Editorial.builder()
                .nombre("Editorial 1")
                .direccion("Direccion 1")
                .telefono("123456789")
                .email("editorial1@gmail.com").build();

        Mockito.when(editorialService.saveEditorial(newEditorial)).thenReturn("Editorial guardado");
        mockMvc.perform(post("/postEditorial")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            \"nombre\": \"Editorial 1\",
                            \"direccion\":\"Direccion 1\",
                            \"telefono\":\"123456789\",
                            \"email\":\"editorial1@gmail.com\"
                        }
                        """))
                .andExpect(status().isOk());
    }

    @Test
    void testFailSaveEditorial() throws Exception {
        Editorial newEditorial = Editorial.builder()
                .nombre("")
                .direccion("Direccion 1")
                .telefono("123456789")
                .email("editorial1@gmail.com").build();

        Mockito.when(editorialService.saveEditorial(newEditorial)).thenThrow(IllegalArgumentException.class);
        mockMvc.perform(post("/postEditorial")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            \"nombre\": \"\",
                            \"direccion\":\"Direccion 1\",
                            \"telefono\":\"123456789\",
                            \"email\":\"editorial1@gmail.com\"
                        }
                        """))
                .andExpect(status().isBadRequest());
    }
}
