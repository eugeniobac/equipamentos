package br.com.gerenciador.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import br.com.gerenciador.util.ConvertPasswordToMD5;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3972181393046015424L;

	@Id
	@GeneratedValue(generator = "usuario_seq")
	@GenericGenerator(name = "usuario_seq", strategy = "increment")
	private Integer id;

	private String nome;

	@Column(unique = true)
	private String cpf;

	@ManyToOne
	private Orgao orgao = new Orgao();

	private String email;

	@Column(unique = true)
	private String login;
	private String senha;

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

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null) {
			this.senha = ConvertPasswordToMD5.convertToMD5(senha);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
