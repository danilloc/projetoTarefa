package com.example.projeto_tarefa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@SpringBootApplication
public class ProjetoTarefaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTarefaApplication.class, args);
	}

	@RequestMapping("/hello")
	public String Hello(){
		return "A aplicação Projeto Tarefa foi iniciada com sucesso! 🚀";
	}

}
