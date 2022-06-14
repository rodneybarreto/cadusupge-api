package br.dev.rodneybarreto.cadusupgeapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Funcao implements Serializable {
	
	private static final long serialVersionUID = 553872379771048034L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@OneToMany(mappedBy="funcao")
	private List<Papel> papeis;
	
	public Funcao() {
	}

	public Funcao(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
}
