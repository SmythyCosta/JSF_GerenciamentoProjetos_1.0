package br.com.projetos.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.projetos.converters.ConverterGrupo;
import br.com.projetos.converters.ConverterSetor;
import br.com.projetos.dao.FuncionarioDAO;
import br.com.projetos.dao.GrupoDAO;
import br.com.projetos.dao.SetorDAO;
import br.com.projetos.models.Funcionario;

@ManagedBean(name="controleFuncionario")
@SessionScoped
public class FuncionarioControle implements Serializable {
	
	private FuncionarioDAO dao;
	private Funcionario objeto;
	
	private GrupoDAO daoGrupo;
	private SetorDAO daoSetor;
	private ConverterGrupo converterGrupo;
	private ConverterSetor converterSetor;
	
	
	public FuncionarioControle(){
		dao = new FuncionarioDAO();
		daoGrupo = new GrupoDAO();
		daoSetor = new SetorDAO();
		converterGrupo = new ConverterGrupo();
		converterSetor = new ConverterSetor();
	}
	
	public String listar(){
		return "/privado/funcionario/listar";
	}
	
	public String novo(){
		objeto = new Funcionario();
		return "form";
	}
	
	public String cancelar(){
		return "listar";
	}
	
	public String gravar(){
		if (dao.gravar(objeto)){
			return "listar";
		}else {
			return "form";
		}
	}
	
	public String alterar(Funcionario obj){
		objeto = obj;
		return "form";
	}
	
	public String excluir(Funcionario obj){
		dao.excluir(obj);
		return "listar";
	}
	
	
	// gets and
	// sets

	public FuncionarioDAO getDao() {
		return dao;
	}
	public void setDao(FuncionarioDAO dao) {
		this.dao = dao;
	}
	public Funcionario getObjeto() {
		return objeto;
	}
	public void setObjeto(Funcionario objeto) {
		this.objeto = objeto;
	}
	public GrupoDAO getDaoGrupo() {
		return daoGrupo;
	}
	public void setDaoGrupo(GrupoDAO daoGrupo) {
		this.daoGrupo = daoGrupo;
	}
	public SetorDAO getDaoSetor() {
		return daoSetor;
	}
	public void setDaoSetor(SetorDAO daoSetor) {
		this.daoSetor = daoSetor;
	}
	public ConverterGrupo getConverterGrupo() {
		return converterGrupo;
	}
	public void setConverterGrupo(ConverterGrupo converterGrupo) {
		this.converterGrupo = converterGrupo;
	}
	public ConverterSetor getConverterSetor() {
		return converterSetor;
	}
	public void setConverterSetor(ConverterSetor converterSetor) {
		this.converterSetor = converterSetor;
	}
	
}
