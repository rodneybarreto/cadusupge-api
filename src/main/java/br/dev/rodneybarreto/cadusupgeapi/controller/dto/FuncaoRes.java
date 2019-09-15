package br.dev.rodneybarreto.cadusupgeapi.controller.dto;

import java.util.List;

public class FuncaoRes {
	
	private String id;
	private String nome;
	private List<PapelRes> papeis;
	
	public FuncaoRes() { }
	
	public FuncaoRes(String id, String nome) {
		this.id = id;
		this.nome = nome; 
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<PapelRes> getPapeis() {
		return papeis;
	}
	
	public void setPapeis(List<PapelRes> papeis) {
		this.papeis = papeis;
	}

}
