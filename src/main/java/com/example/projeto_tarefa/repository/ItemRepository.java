package com.example.projeto_tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto_tarefa.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
