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

import br.com.faespsenar.controleinterno.enumerator.TipoMarca;

@Entity
public class Impressora implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Descrição é obrigatoria")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "departamento_codigo", nullable = false)
	private Departamento departamento = new Departamento();
	
	private String ip;
	private String patrimonio;
	
	@Enumerated(EnumType.STRING)
	private TipoMarca marca;
	
	private Integer codigoMaquina;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}
	public TipoMarca getMarca() {
		return marca;
	}
	public void setMarca(TipoMarca marca) {
		this.marca = marca;
	}
	public Integer getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(Integer codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	
}