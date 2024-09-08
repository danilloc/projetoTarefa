package com.example.projeto_tarefa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto_tarefa.model.Item;
import com.example.projeto_tarefa.model.Lista;
import com.example.projeto_tarefa.repository.ItemRepository;
import com.example.projeto_tarefa.repository.ListaRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListaRepository listaRepository;

    public Item criarItem(Long listaId, Item item) {
        Lista lista = listaRepository.findById(listaId).orElseThrow();
        item.setLista(lista);
        return itemRepository.save(item);
    }

    public List<Item> listarItensPorLista(Long listaId) {
        Lista lista = listaRepository.findById(listaId).orElseThrow();
        return lista.getItens();
    }

    public void removerItem(Long id) {
        itemRepository.deleteById(id);
    }
}
