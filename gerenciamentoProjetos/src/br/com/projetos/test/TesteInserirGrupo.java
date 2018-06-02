package br.com.projetos.test;

import javax.persistence.EntityManager;

import br.com.projetos.jpa.EntityManagerUtil;
import br.com.projetos.models.Grupo;

public class TesteInserirGrupo {

	public static void main(String[] args) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		Grupo g = new Grupo();
		g.setNome("Gestores");
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
	}

}
