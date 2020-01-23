package br.com.faespsenar.controleinterno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faespsenar.controleinterno.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{
	// Spring Data ja tem uma implementacao generica para salvar, editar , excluir etc
	
	
}
