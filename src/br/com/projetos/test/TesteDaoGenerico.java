package br.com.projetos.test;

import java.util.List;

import br.com.projetos.dao.SetorDAO;
import br.com.projetos.models.Setor;

public class TesteDaoGenerico {

	public static void main(String[] args) {
		SetorDAO dao = new SetorDAO();
		List<Setor> lista = dao.listar();
		for (Setor o : lista){
			System.out.println("Codigo: "+o.getId()+" Nome: "+o.getNome());
		}
	}

}
