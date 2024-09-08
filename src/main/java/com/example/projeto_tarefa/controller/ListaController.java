package com.example.projeto_tarefa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_tarefa.model.Lista;
import com.example.projeto_tarefa.service.ListaService;

@RestController
@RequestMapping("/api/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    // Criar nova lista
    @PostMapping
    public ResponseEntity<Lista> criarLista(@RequestBody Lista lista) {
        Lista novaLista = listaService.criarLista(lista);
        return ResponseEntity.ok(novaLista);
    }

    // Listar todas as listas
    @GetMapping
    public ResponseEntity<List<Lista>> listarTodasAsListas() {
        List<Lista> listas = listaService.listarTodasAsListas();
        return ResponseEntity.ok(listas);
    }

    // Buscar lista por ID
    @GetMapping("/{id}")
    public ResponseEntity<Lista> buscarListaPorId(@PathVariable Long id) {
        Optional<Lista> lista = listaService.buscarListaPorId(id);
        return lista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Remover lista por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLista(@PathVariable Long id) {
        listaService.removerLista(id);
        return ResponseEntity.noContent().build();
    }
}
