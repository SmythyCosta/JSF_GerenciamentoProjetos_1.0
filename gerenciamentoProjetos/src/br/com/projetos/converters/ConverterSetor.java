package br.com.projetos.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.projetos.jpa.EntityManagerUtil;
import br.com.projetos.models.Setor;

public class ConverterSetor implements Converter, Serializable {
	
	// converte da tela para o objeto
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.equals("Selecione um setor")) {
			return null;
		}
		return EntityManagerUtil.getEntityManager().find(Setor.class, Integer.parseInt(string));
	}

	// converte do objeto para a tela
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object o) {
		if (o == null) {
			return null;
		}
		Setor obj = (Setor) o;
		return obj.getId().toString();
	}
}
