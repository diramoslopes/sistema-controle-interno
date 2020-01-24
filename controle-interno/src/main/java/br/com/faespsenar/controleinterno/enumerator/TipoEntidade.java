package br.com.faespsenar.controleinterno.enumerator;

public enum TipoEntidade {
		FAESP("Faesp"),
		SENAR("Senar"),
		FAESPSENAR("FaespSenar"),
		CONDOMÍNIO("Condomínio");
		
		private final String descricao;
		
		private TipoEntidade(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return this.descricao;
		}
}