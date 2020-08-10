/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.automoveis.controller;

import com.diego.automoveis.entity.Automovel;
import com.diego.automoveis.service.JPAUtil;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;


/**
 *
 * @author diego
 */
@ManagedBean
public class AutomovelBean {

	private Automovel automovel = new Automovel();

	// getter e setter
	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public void salva() {
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(automovel);
		em.getTransaction().commit();
		
		em.close();
	}
}
