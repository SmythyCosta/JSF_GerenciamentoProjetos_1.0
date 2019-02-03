package br.com.projetos.dao;

import java.io.Serializable;

import br.com.projetos.converters.ConverterOrdem;
import br.com.projetos.jpa.EntityManagerUtil;
import br.com.projetos.models.Setor;

@SuppressWarnings("serial")
public class DAOSetor<T> extends GenericDAO<T> implements Serializable {
	
	public DAOSetor(){
		super.setClasse(Setor.class);
		super.setEm(EntityManagerUtil.getEntityManager());
		super.getListaOrdem().add(new Ordem("Codigo", "id"));
		super.getListaOrdem().add(new Ordem("Nome", "nome"));
		super.setOrdemAtual((Ordem) super.getListaOrdem().get(1));
		super.setFiltro("");
		super.setMaximoObjetos(2);
		super.setConverterOrdem(new ConverterOrdem(super.getListaOrdem()));
	}

}
