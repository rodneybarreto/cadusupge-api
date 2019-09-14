package br.dev.rodneybarreto.cadusupgeapi.controller.dto;

public class UsuarioReq {
	
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String genero;
	private String funcaoId;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getFuncaoId() {
		return funcaoId;
	}

	public void setFuncaoId(String funcaoId) {
		this.funcaoId = funcaoId;
	}

}
