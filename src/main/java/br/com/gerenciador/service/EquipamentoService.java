package br.com.gerenciador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gerenciador.base.GenericService;
import br.com.gerenciador.entity.Equipamento;
import br.com.gerenciador.repository.EquipamentoRepository;

@Service
@Transactional
public class EquipamentoService extends GenericService<Equipamento> {

	@Autowired
	private EquipamentoRepository repository;

	@Override
	public EquipamentoRepository getRepository() {
		return repository;
	}

}
