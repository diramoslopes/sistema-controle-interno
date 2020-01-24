package br.com.faespsenar.controleinterno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faespsenar.controleinterno.model.Departamento;

public interface Departamentos extends JpaRepository<Departamento, Long>{
	// Spring Data ja tem uma implementacao generica para salvar, editar , excluir etc
	// JpaRepository já tem varios metodos para que possamos trabalhar
	
}
