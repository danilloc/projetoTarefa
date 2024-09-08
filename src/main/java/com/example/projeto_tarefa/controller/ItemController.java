package com.example.projeto_tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_tarefa.model.Item;
import com.example.projeto_tarefa.service.ItemService;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Criar novo item em uma lista
    @PostMapping("/lista/{listaId}")
    public ResponseEntity<Item> criarItem(@PathVariable Long listaId, @RequestBody Item item) {
        Item novoItem = itemService.criarItem(listaId, item);
        return ResponseEntity.ok(novoItem);
    }
    
    // Listar todos os itens de uma lista
    @GetMapping("/lista/{listaId}")
    public ResponseEntity<List<Item>> listarItensPorLista(@PathVariable Long listaId) {
        List<Item> itens = itemService.listarItensPorLista(listaId);
        return ResponseEntity.ok(itens);
    }

    // Remover item por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerItem(@PathVariable Long id) {
        itemService.removerItem(id);
        return ResponseEntity.noContent().build();
    }
}
