package br.com.faespsenar.controleinterno.enumerator;

public enum TipoStatus {
	ARQUIVADO("Arquivado"),  
	ATIVO("Ativo"),
	EMPRESTIMO("Empréstimo"), 
	ESTOQUE("Estoque"),
	INATIVO("Inativo"),    
	MANUTENCAO("Manutenção");
	
	private final String descricao;
	
	private TipoStatus(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}