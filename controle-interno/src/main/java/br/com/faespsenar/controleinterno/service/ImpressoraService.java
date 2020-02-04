package br.com.faespsenar.controleinterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.model.Impressora;
import br.com.faespsenar.controleinterno.repository.Impressoras;
import br.com.faespsenar.controleinterno.repository.filter.ImpressoraFilter;

@Service
public class ImpressoraService {
	
	@Autowired
	private Impressoras impressoras;
	
	public void salvar(Impressora impressora) {
		impressoras.save(impressora);
	}	
	
	public void excluir(Long codigo) {
		impressoras.deleteById(codigo);
	}
	
	public List<Impressora> filtrar(ImpressoraFilter filtro){
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return impressoras.findByDescricaoContaining(descricao);
	}
	
}