package br.com.gerenciador.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gerenciador.base.GenericBean;
import br.com.gerenciador.base.GenericService;
import br.com.gerenciador.entity.Usuario;
import br.com.gerenciador.service.UsuarioService;

@Component
public class UsuarioBean extends GenericBean<Usuario> {

	@Autowired
	private UsuarioService service;

	private Usuario entity;

	public String create() {
		reset();
		list = getAll();
		return "usuario.xhtml?faces-redirect=true";
	}

	public void reset() {
		entity = new Usuario();
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

	@Override
	public GenericService<Usuario> getService() {
		return service;
	}

	@Override
	public Usuario getEntity() {
		return entity;
	}

	public void setEntity(Usuario entity) {
		this.entity = entity;
	}

	@Override
	public List<Usuario> getList() {
		return list;
	}

	@Override
	public void setList(List<Usuario> list) {
		this.list = list;
	}

}