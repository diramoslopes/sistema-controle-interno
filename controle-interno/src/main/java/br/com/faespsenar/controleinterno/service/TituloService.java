package br.com.faespsenar.controleinterno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.enumerator.StatusTitulo;
import br.com.faespsenar.controleinterno.model.Titulo;
import br.com.faespsenar.controleinterno.repository.Titulos;
import br.com.faespsenar.controleinterno.repository.filter.TituloFilter;

@Service
public class TituloService {
	
	@Autowired
	private Titulos titulos;
	
	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data invalido!");
		}
	}

	public void excluir(Long codigo) {
		titulos.deleteById(codigo);
	}

	public String receber(Long codigo) {
		Optional<Titulo> titulo = titulos.findById(codigo);
		titulo.get().setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo.get());
		return StatusTitulo.RECEBIDO.getDescricao();
	}
	
	public List<Titulo> filtrar(TituloFilter filtro){
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return titulos.findByDescricaoContaining(descricao);
	}
	
}
