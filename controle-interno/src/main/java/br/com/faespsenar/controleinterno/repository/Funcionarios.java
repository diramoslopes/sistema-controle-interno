package br.com.faespsenar.controleinterno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faespsenar.controleinterno.model.Funcionario;

public interface Funcionarios extends JpaRepository<Funcionario, Long> {

	// Spring Data ja tem uma implementacao generica para salvar, editar , excluir etc
	// JpaRepository já tem varios metodos para que possamos trabalhar
	
	List<Funcionario> findByNomeFuncionarioContaining(String nomeFuncionario);
}
