package br.com.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByLogin(String login);

}
