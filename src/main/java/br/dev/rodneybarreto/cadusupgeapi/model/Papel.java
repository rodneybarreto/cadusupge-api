package br.dev.rodneybarreto.cadusupgeapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Papel implements Serializable {

	private static final long serialVersionUID = -33369155117727411L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	@ManyToOne
	private Funcao funcao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
}
