package br.com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.entity.Orgao;

public interface OrgaoRepository extends JpaRepository<Orgao, Integer> {

}
