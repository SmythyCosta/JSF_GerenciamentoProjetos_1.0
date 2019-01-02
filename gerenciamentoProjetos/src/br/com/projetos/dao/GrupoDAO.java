package br.com.projetos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.projetos.jpa.EntityManagerUtil;
import br.com.projetos.models.Grupo;
import br.com.projetos.util.UtilErros;
import br.com.projetos.util.UtilMensagens;

public class GrupoDAO {
	
	private EntityManager em;
	
	public GrupoDAO() {
		// TODO Auto-generated constructor stub
		em = EntityManagerUtil.getEntityManager();
	}
	
	public List<Grupo> ListarTodos(){
		return em.createQuery("from Grupo order by id desc").getResultList();
	}
	
	public boolean gravar(Grupo obj){
		try {
			em.getTransaction().begin();
			if (obj.getId() == null){
				em.persist(obj);
			} else {
				em.merge(obj);
			}
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Objeto persistido com sucesso!");
			return true;

		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao persistir objeto: "+
												UtilErros.getMensagemErro(e));
			return false;
		}
	}
	
	public boolean excluir(Grupo obj){
		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
			return true;
			
		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao remover objeto: "+
												UtilErros.getMensagemErro(e));
			return false;
		}
	}
	
	public Grupo localizar(Integer id){
		return em.find(Grupo.class, id);
	}
	
	
	// *************************
	// gets and
	// sets
	// *************************

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}


}
