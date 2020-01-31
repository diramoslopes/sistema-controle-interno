package br.com.faespsenar.controleinterno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.model.Equipamento;
import br.com.faespsenar.controleinterno.repository.Equipamentos;

@Service
public class EquipamentoService {
	
	@Autowired
	private Equipamentos equipamentos;
	
	public void salvar(Equipamento equipamento) {
		equipamentos.save(equipamento);
	}

	public void excluir(Long codigo) {
		equipamentos.deleteById(codigo);
	}
	
}
