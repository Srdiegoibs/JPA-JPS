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
import javax.persistence.Query;

/**
 * @author diego
 * Created on : Aug 17, 2020, 9:49:34 PM
 */
@ManagedBean
@ViewScoped
public class MarcaBean {
	private Marca marca = new Marca();
	private List<Marca> marcas;
	
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

	public List<Marca> getMarcas() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select m from Marca m", Marca.class);

		this.marcas = q.getResultList();
		em.close();
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
