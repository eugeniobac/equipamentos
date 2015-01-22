package br.com.gerenciador.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Orgao implements Serializable {

	private static final long serialVersionUID = -222077939429903472L;

	@Id
	@GeneratedValue(generator = "orgao_seq")
	@GenericGenerator(name = "orgao_seq", strategy = "increment")
	private Integer id;

	@Column(unique = true)
	private String nome;

	@Column(unique = true)
	private String sigla;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
