/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diego.automoveis.converter;

import com.diego.automoveis.entity.Automovel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import com.diego.automoveis.service.JPAUtil;


/**
 * @author diego
 * Created on : Aug 24, 2020, 12:27:25 PM
 */
@FacesConverter("entityConverter")
public class AutmovelConverter implements Converter{

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Automovel automovel = (Automovel) object;
		if (automovel == null || automovel.getId() == 0) return null;
		
		return String.valueOf(automovel.getId());
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty()) return null;
		Integer id = Integer.valueOf(string);
		
		Automovel automovel = JPAUtil.getEntityManager().find(Automovel.class, id);
		return automovel;
	}
}
