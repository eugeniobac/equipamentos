package br.com.gerenciador.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gerenciador.base.GenericBean;
import br.com.gerenciador.base.GenericService;
import br.com.gerenciador.entity.Equipamento;
import br.com.gerenciador.service.EquipamentoService;

@Component
public class EquipamentoBean extends GenericBean<Equipamento> {

	@Autowired
	private EquipamentoService service;

	private Equipamento entity;

	@Autowired
	private LoginBean loginBean;

	public String create() {
		reset();
		list = findAll();
		return "equipamento.xhtml?faces-redirect=true";
	}

	@Override
	public void save() {
		entity.setUsuarioCadastro(loginBean.getUsuario());

		super.save();
	}

	public void reset() {
		entity = new Equipamento();
	}

	public void setService(EquipamentoService service) {
		this.service = service;
	}

	@Override
	public GenericService<Equipamento> getService() {
		return service;
	}

	@Override
	public Equipamento getEntity() {
		return entity;
	}

	public void setEntity(Equipamento entity) {
		this.entity = entity;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}