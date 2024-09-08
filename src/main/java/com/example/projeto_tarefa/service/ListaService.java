package com.example.projeto_tarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto_tarefa.model.Lista;
import com.example.projeto_tarefa.repository.ListaRepository;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public Lista criarLista(Lista lista) {
        return listaRepository.save(lista);
    }

    public List<Lista> listarTodasAsListas() {
        return listaRepository.findAll();
    }

    public Optional<Lista> buscarListaPorId(Long id) {
        return listaRepository.findById(id);
    }

    public void removerLista(Long id) {
        listaRepository.deleteById(id);
    }
}
