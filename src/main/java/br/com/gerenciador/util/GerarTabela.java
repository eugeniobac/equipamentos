package br.com.gerenciador.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabela {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("equipamentos");
		factory.createEntityManager();

		System.exit(0);
	}
}
