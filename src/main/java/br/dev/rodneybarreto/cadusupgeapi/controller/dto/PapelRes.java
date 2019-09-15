package br.dev.rodneybarreto.cadusupgeapi.controller.dto;

import br.dev.rodneybarreto.cadusupgeapi.model.Papel;

public class PapelRes {
	
	private String id;
	private String descricao;
	
	public PapelRes() { }
	
	public PapelRes(Papel papel) {
		this.id = papel.getId().toString();
		this.descricao = papel.getDescricao();
	}
	
	public String getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
