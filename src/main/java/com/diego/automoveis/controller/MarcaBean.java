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
import javax.persistence.EntityManager;

/**
 * @author diego
 * Created on : Aug 17, 2020, 9:49:34 PM
 */
@ManagedBean
public class MarcaBean {

	private List<Marca> marcas;
	
	@PostConstruct
	public void carregaMarca() {
		 EntityManager em = JPAUtil.getEntityManager();
		 marcas = em.createQuery("SELECT m  FROM Marca m", Marca.class).getResultList();
		 em.close();
	}
	
	
	public List<Marca> getMarcas() {
		return marcas;
	}

}
