package com.example.projeto_tarefa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ListaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCriarLista() throws Exception {
        String listaJson = "{\"titulo\":\"Nova Lista\"}";

        mockMvc.perform(post("/api/listas")
                .contentType("application/json")
                .content(listaJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Nova Lista"));
    }
}
