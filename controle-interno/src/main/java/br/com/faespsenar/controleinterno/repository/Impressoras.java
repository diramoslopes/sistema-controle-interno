package br.com.faespsenar.controleinterno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faespsenar.controleinterno.model.Impressora;

public interface Impressoras extends JpaRepository<Impressora, Long>{
	
	List<Impressora> findByDescricaoContaining(String descricao);
	
}
