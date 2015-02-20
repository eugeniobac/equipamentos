package br.com.gerenciador.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gerenciador.base.GenericBean;
import br.com.gerenciador.base.GenericService;
import br.com.gerenciador.entity.Orgao;
import br.com.gerenciador.service.OrgaoService;

@Component
public class OrgaoBean extends GenericBean<Orgao> {

	@Autowired
	private OrgaoService service;

	private Orgao entity;

	public String create() {
		reset();
		list = getAll();

		return "orgao.xhtml?faces-redirect=true";
	}

	public void reset() {
		entity = new Orgao();
	}

	public void setService(OrgaoService service) {
		this.service = service;
	}

	@Override
	public GenericService<Orgao> getService() {
		return service;
	}

	@Override
	public Orgao getEntity() {
		return entity;
	}

	public void setEntity(Orgao entity) {
		this.entity = entity;
	}

}