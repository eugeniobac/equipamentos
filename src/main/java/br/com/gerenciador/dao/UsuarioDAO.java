package br.com.gerenciador.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.gerenciador.entity.Orgao;
import br.com.gerenciador.entity.Usuario;

@Repository
public class UsuarioDAO implements Serializable {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Usuario usuario) {
		Orgao orgao = new Orgao();
		orgao.setNome("gabgov");

		getSessionFactory().getCurrentSession().save(usuario);
		getSessionFactory().getCurrentSession().save(orgao);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
