/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diego.automoveis.controller;

import com.diego.automoveis.entity.Marca;
import com.diego.automoveis.service.JPAUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

/**
 * @author diego
 * Created on : Aug 17, 2020, 9:49:34 PM
 */
@ManagedBean
@ViewScoped
public class MarcaBean {
	private Marca marca = new Marca();
	
	public String salvar() {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.persist(marca);
			return "listar?faces-redirect=true";
		}
		catch(Exception e) {
				return "falha";
		}
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
