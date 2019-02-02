package br.com.projetos.test;

import javax.persistence.EntityManager;

import br.com.projetos.jpa.EntityManagerUtil;
import br.com.projetos.models.Setor;

public class TesteInserirSetor {

	public static void main(String[] args) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor obj = new Setor();
		obj.setNome("Operacional");
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		System.out.println("OK insert");
	}

}
