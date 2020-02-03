package br.com.faespsenar.controleinterno.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.faespsenar.controleinterno.enumerator.StatusTitulo;
import br.com.faespsenar.controleinterno.model.Titulo;
import br.com.faespsenar.controleinterno.repository.Titulos;

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
	
}
