package br.com.projetos.test;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.projetos.jpa.EntityManagerUtil;
import br.com.projetos.models.Funcionario;
import br.com.projetos.models.Projeto;
import br.com.projetos.models.ProjetoFuncionario;
import br.com.projetos.models.Setor;

public class TesteInserirProjeto {

	public static void main(String args[]){
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor setor = em.find(Setor.class, 1);
		Funcionario func = em.find(Funcionario.class, 1);
		Projeto projeto = new Projeto();
		projeto.setAtivo(true);
		projeto.setDescricao("Descricao Projeto 1");
		projeto.setFim(Calendar.getInstance());
		projeto.setInicio(Calendar.getInstance());
		projeto.setNome("Projeto 1");
		projeto.setSetor(setor);
		ProjetoFuncionario pf = new ProjetoFuncionario();
		pf.setCargaHoraria(100);
		pf.setFimParticipacao(Calendar.getInstance());
		pf.setFuncionario(func);
		pf.setGestor(true);
		pf.setInicioParticipacao(Calendar.getInstance());
		projeto.adicionarFuncionario(pf);
		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
	}
}
