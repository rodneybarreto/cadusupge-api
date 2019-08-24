package br.dev.rodneybarreto.cadusupgeapi.controller.dto;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.time.format.DateTimeFormatter;

import br.com.caelum.stella.format.CPFFormatter;
import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;

public class UsuarioRes {
	
	private String id;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String genero;
	private String funcao;
	
	public UsuarioRes() {
	}
	
	public UsuarioRes(Usuario usuario) {
		id = usuario.getId().toString();
		nome = usuario.getNome();
		
		CPFFormatter cpfFormatter = new CPFFormatter();
		cpf = (isEmpty(usuario.getCpf()) ? "" : cpfFormatter.format(usuario.getCpf()));
		
		DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataNascimento = usuario.getDataNascimento().format(dataFormatter);
		
		genero = usuario.getGenero().toString();
		funcao = usuario.getFuncao().getNome();
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
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
