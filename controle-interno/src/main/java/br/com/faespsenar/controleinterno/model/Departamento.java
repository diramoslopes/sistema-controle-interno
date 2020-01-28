package br.com.faespsenar.controleinterno.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.faespsenar.controleinterno.enumerator.TipoAndar;
import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Departamento é obrigatório")
	@Size(max = 30, message = "Nome do Departamento tamanho máx 30")
	private String nomeDepartamento;
	
	@Enumerated(EnumType.STRING)
	private TipoEntidade entidade;
	
	@NotEmpty(message = "Chefia é obrigatório")
	private String chefia;
	
	@Enumerated(EnumType.STRING)
	private TipoAndar andar;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public TipoEntidade getEntidade() {
		return entidade;
	}

	public void setEntidade(TipoEntidade entidade) {
		this.entidade = entidade;
	}

	public String getChefia() {
		return chefia;
	}

	public void setChefia(String chefia) {
		this.chefia = chefia;
	}

	public TipoAndar getAndar() {
		return andar;
	}

	public void setAndar(TipoAndar andar) {
		this.andar = andar;
	}
}