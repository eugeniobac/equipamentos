package br.com.gerenciador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gerenciador.base.GenericService;
import br.com.gerenciador.entity.Orgao;
import br.com.gerenciador.repository.OrgaoRepository;

@Service
@Transactional
public class OrgaoService extends GenericService<Orgao> {

	@Autowired
	private OrgaoRepository repository;

	@Override
	public OrgaoRepository getRepository() {
		return repository;
	}

	public void setRepository(OrgaoRepository repository) {
		this.repository = repository;
	}

}
