package br.com.faespsenar.controleinterno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.model.Funcionario;
import br.com.faespsenar.controleinterno.repository.Funcionarios;

@Service
public class FuncionarioService {
	
	@Autowired
	private Funcionarios funcionarios;

	public void salvar(Funcionario funcionario) {
		funcionarios.save(funcionario);
	}

	public void excluir(Long codigo) {
		funcionarios.deleteById(codigo);
	}
	
}
