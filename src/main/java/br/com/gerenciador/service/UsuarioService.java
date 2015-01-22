package br.com.gerenciador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gerenciador.base.GenericService;
import br.com.gerenciador.entity.Usuario;
import br.com.gerenciador.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UsuarioRepository getRepository() {
		return repository;
	}

	public void setRepository(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Usuario findByLogin(String login) {
		return repository.findByLogin(login);
	}

}
