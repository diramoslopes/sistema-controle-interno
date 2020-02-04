package br.com.faespsenar.controleinterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.model.Departamento;
import br.com.faespsenar.controleinterno.repository.Departamentos;
import br.com.faespsenar.controleinterno.repository.filter.DepartamentoFilter;

@Service
public class DepartamentoService {
	
	@Autowired
	private Departamentos departamentos;
	
	public void salvar(Departamento departamento) {
		departamentos.save(departamento);
	}

	public void excluir(Long codigo) {
		departamentos.deleteById(codigo);
	}

	public List<Departamento> filtrar(DepartamentoFilter filtro) {
		String nomeDepartamento = filtro.getNomeDepartamento() == null ? "%" : filtro.getNomeDepartamento();
		
		return departamentos.findByNomeDepartamentoContaining(nomeDepartamento);
		
		}
	
}
