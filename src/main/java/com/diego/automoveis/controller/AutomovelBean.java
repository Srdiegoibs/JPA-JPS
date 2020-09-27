/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.automoveis.controller;

import com.diego.automoveis.entity.Automovel;
import com.diego.automoveis.entity.Marca;
import com.diego.automoveis.service.JPAUtil;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author diego
 */
@ManagedBean
@ViewScoped
public class AutomovelBean {

	private boolean exibe = false;

	private Automovel automovel = new Automovel();
	private List<Automovel> automoveis;
	private Marca marca; // utilitário para buscar os modelos

	// Methos
	public void listener(ActionEvent event) {
		UIComponent source = event.getComponent();
		System.out.println("Ação executada no componente "
				+ source.getId());
	}

	public void salva() {
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(automovel);
		em.getTransaction().commit();

		em.close();
	}

	public void excluir(Automovel automovel) {
		EntityManager em = JPAUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		automovel = em.merge(automovel);
		em.remove(automovel);
		tx.commit();
		em.close();
	}

	// getter e setter
	public List<Automovel> getAutomoveis() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Automovel a", Automovel.class);

		this.automoveis = q.getResultList();
		em.close();
		return automoveis;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setAutomoveis(List<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public boolean isExibe() {
		return exibe;
	}

	public void setExibe(boolean exibe) {
		this.exibe = exibe;
	}
}
