package br.com.gerenciador.bean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gerenciador.base.GenericService;
import br.com.gerenciador.entity.Usuario;
import br.com.gerenciador.service.UsuarioService;
import br.com.gerenciador.util.MessageView;

@SessionScoped
@Component
public class LoginBean {

	public static final String USUARIO_LOGADO = "UsuarioLogado";

	@Autowired
	private UsuarioService service;

	private Usuario usuario = new Usuario();

	public String login() {
		usuario = service.findByLogin(usuario.getLogin());

		if (usuario == null) {
			MessageView.error("Usuario não encontrado");
		} else if (usuario.getSenha().equals(usuario.getSenha())) {
			getExternalContext().getSessionMap().put(USUARIO_LOGADO, usuario);

			return "home.xhtml";
		} else {
			MessageView.error("Senha inválida");
		}

		return null;
	}

	public String logout() {
		getExternalContext().getSessionMap().remove(USUARIO_LOGADO);
		usuario = new Usuario();

		return "index.xhtml";
	}

	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

	public GenericService<Usuario> getService() {
		return service;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}