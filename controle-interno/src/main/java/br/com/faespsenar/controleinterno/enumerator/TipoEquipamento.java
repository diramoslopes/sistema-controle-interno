package br.com.faespsenar.controleinterno.enumerator;

public enum TipoEquipamento {
	MICRO("Micro"),
	CPU("CPU"),
	NOTEBOOK("Notebook"),
	IMPRESSORA("Impressora"),
	COPIADORA("Copiadora"),
	MONITOR("Monitor"),
	SERVIDOR("Servidor"),
	PROJETOR("Projetor"),
	SCANNER("Scanner"),
	SWITCH("Switch"),
	ESTABILIZADOR("Estabilizador"),
	CAMERA_FOTOGRAFICA("Câmera fotográfica"),
	ADAPTADOR_SEM_FIO("Adaptador sem fio"),
	TABLET("Tablet");
	
	private final String descricao;
	
	private TipoEquipamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}