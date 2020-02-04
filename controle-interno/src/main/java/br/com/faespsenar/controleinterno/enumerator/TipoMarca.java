package br.com.faespsenar.controleinterno.enumerator;

public enum TipoMarca {
	
	HP("Hp"),
	EPSON("Epson");

	private final String descricao;

	private TipoMarca(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}

