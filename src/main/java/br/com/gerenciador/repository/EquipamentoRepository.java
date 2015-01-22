package br.com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.entity.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

}
