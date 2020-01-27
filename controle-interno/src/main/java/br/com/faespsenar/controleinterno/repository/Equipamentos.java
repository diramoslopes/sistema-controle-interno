package br.com.faespsenar.controleinterno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faespsenar.controleinterno.model.Equipamento;

public interface Equipamentos extends JpaRepository<Equipamento, Long> {
		// Spring Data ja tem uma implementacao generica para salvar, editar , excluir etc
		// JpaRepository já tem varios metodos para que possamos trabalhar
}
