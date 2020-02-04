package br.com.faespsenar.controleinterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.model.Funcionario;
import br.com.faespsenar.controleinterno.repository.Funcionarios;
import br.com.faespsenar.controleinterno.repository.filter.FuncionarioFilter;

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

	public List<Funcionario> filtrar(FuncionarioFilter filtro) {
		String nomeFuncionario = filtro.getNomeFuncionario() == null ? "%" : filtro.getNomeFuncionario();
		return funcionarios.findByNomeFuncionarioContaining(nomeFuncionario);
	}
	
}
