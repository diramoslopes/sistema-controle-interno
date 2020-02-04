package br.com.faespsenar.controleinterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.model.Equipamento;
import br.com.faespsenar.controleinterno.repository.Equipamentos;
import br.com.faespsenar.controleinterno.repository.filter.EquipamentoFilter;

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

	public List<Equipamento> filtrar(EquipamentoFilter filtro) {
		String numeroDePatrimonio =  filtro.getNumeroDePatrimonio() == null ? "%" : filtro.getNumeroDePatrimonio();
		return equipamentos.findByNumeroDePatrimonioContaining(numeroDePatrimonio);
	}
	
}
