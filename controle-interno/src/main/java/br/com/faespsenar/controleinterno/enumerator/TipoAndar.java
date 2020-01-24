package br.com.faespsenar.controleinterno.enumerator;

public enum TipoAndar {
	
		TERREO("Térreo"),
		ANDAR_1("1º Andar"),
		ANDAR_2("2º Andar"),
		ANDAR_3("3º Andar"),
		ANDAR_4("4º Andar"),
		ANDAR_5("5º Andar"),
		ANDAR_6("6º Andar"),
		ANDAR_7("7º Andar"),
		ANDAR_8("8º Andar"),
		ANDAR_9("9º Andar"),
		ANDAR_10("10º Andar"),
		ANDAR_11("11º Andar"),
		ANDAR_12("12º Andar"),
		ANDAR_13("13º Andar"),
		ANDAR_14("14º Andar");

		private final String descricao;

		private TipoAndar(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return this.descricao;
		}
}