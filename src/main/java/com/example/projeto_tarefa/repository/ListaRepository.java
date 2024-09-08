package com.example.projeto_tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto_tarefa.model.Lista;

public interface ListaRepository extends JpaRepository<Lista, Long> {
}
