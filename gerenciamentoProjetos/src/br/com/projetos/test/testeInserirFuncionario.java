package br.com.projetos.test;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.projetos.jpa.EntityManagerUtil;
import br.com.projetos.models.Funcionario;
import br.com.projetos.models.Grupo;
import br.com.projetos.models.Setor;

public class testeInserirFuncionario {
	
	public static void main(String args[]){
		EntityManager em = EntityManagerUtil.getEntityManager();
		Grupo grupo = em.find(Grupo.class, 1);
		Setor setor = em.find(Setor.class, 1);
		Funcionario f = new Funcionario();
		f.setAtivo(true);
		f.setCpf("519.554.775-07");
		f.setEmail("joao@email.com");
		f.setGrupo(grupo);
		f.setNascimento(Calendar.getInstance());
		f.setNome("João");
		f.setNomeUsuario("joao");
		f.setSalario(5000.00);
		f.setSenha("12345");
		f.setSetor(setor);
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		System.out.println("OK insert");
	}

}
