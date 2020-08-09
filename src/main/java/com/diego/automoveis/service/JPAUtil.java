/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.automoveis.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Entity;

/**
 *
 * @author diego
 */
public class JPAUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
