package br.com.faespsenar.controleinterno.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;

@Entity
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nomeFuncionario;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private TipoEntidade entidade;
	
	private String ramal;
	
	@ManyToOne
	@JoinColumn(name = "departamento_codigo", nullable = false)
	private Departamento departamento = new Departamento();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public TipoEntidade getEntidade() {
		return entidade;
	}

	public void setEntidade(TipoEntidade entidade) {
		this.entidade = entidade;
	}
	
	
	

}
