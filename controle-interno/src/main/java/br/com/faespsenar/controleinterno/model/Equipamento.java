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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.faespsenar.controleinterno.enumerator.TipoEntidade;
import br.com.faespsenar.controleinterno.enumerator.TipoEquipamento;
import br.com.faespsenar.controleinterno.enumerator.TipoStatus;

@Entity
public class Equipamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "departamento_codigo", nullable = false)
	private Departamento departamento = new Departamento();
	
	@ManyToOne
	@JoinColumn(name = "funcionario_codigo", nullable = false)
	private Funcionario funcionario = new Funcionario();
	
	@Enumerated(EnumType.STRING)
	private TipoEntidade entidade;
	
	@NotEmpty(message = "Patrimonio é obrigatorio")
	@Size(min = 4, max = 4, message = "Patrimonio é necessario 4 digitos")
	String numeroDePatrimonio;
	
	String numeroDeSerie = null;
	
	@Enumerated(EnumType.STRING)
	private TipoEquipamento tipoEquipamento;
	
	@NotEmpty(message = "Marca é obrigatória")
	private String marca = null;
	
	@NotEmpty(message = "Modelo é obrigatório")
	private String modelo = null;
	
	@Enumerated(EnumType.STRING)
	private TipoStatus tipoStatus;
	
	private String observacao = null;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public TipoEntidade getEntidade() {
		return entidade;
	}

	public void setEntidade(TipoEntidade entidade) {
		this.entidade = entidade;
	}

	public String getNumeroDePatrimonio() {
		return numeroDePatrimonio;
	}

	public void setNumeroDePatrimonio(String numeroDePatrimonio) {
		this.numeroDePatrimonio = numeroDePatrimonio;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoStatus getTipoStatus() {
		return tipoStatus;
	}

	public void setTipoStatus(TipoStatus tipoStatus) {
		this.tipoStatus = tipoStatus;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
}
