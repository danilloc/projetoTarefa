package com.example.projeto_tarefa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.projeto_tarefa.repository.ItemRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testCriarItem() throws Exception {
        String itemJson = "{\"titulo\":\"Novo Item\", \"estado\":\"pendente\", \"prioridade\":true}";

        mockMvc.perform(post("/api/itens")
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Novo Item"))
                .andExpect(jsonPath("$.estado").value("pendente"))
                .andExpect(jsonPath("$.prioridade").value(true));
    }

    @Test
    public void testBuscarItemPorId() throws Exception {
        mockMvc.perform(get("/api/itens/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("Comprar leite"));
    }

    @Test
    public void testDeletarItem() throws Exception {
        mockMvc.perform(delete("/api/itens/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAtualizarItem() throws Exception {
        String itemAtualizado = "{\"titulo\":\"Item Atualizado\", \"estado\":\"concluido\", \"prioridade\":false}";

        mockMvc.perform(put("/api/itens/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemAtualizado))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Item Atualizado"))
                .andExpect(jsonPath("$.estado").value("concluido"))
                .andExpect(jsonPath("$.prioridade").value(false));
    }
}