/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.automoveis.service;

import com.diego.automoveis.entity.Automovel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author diego
 */
public class PersistidorDeAutomovel {
	public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Automovel auto = em.getReference(Automovel.class, 2);
		
		tx.begin();
		em.remove(auto);
		tx.commit();
    }
}
