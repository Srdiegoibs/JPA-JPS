///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.diego.automoveis.service;
//
//import com.diego.automoveis.entity.Automovel;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
///**
// *
// * @author diego
// */
//public class PersistidorDeAutomovel {
//	public static void main(String[] args) {
//		EntityManager em = JPAUtil.getEntityManager();
//
//		Automovel auto = new Automovel();
//		auto.setAnoFabricacao(1993);
//		auto.setModelo("diego");
//		auto.setObservacoes("maquina");
//
//		EntityTransaction tx = em.getTransaction();
//
//		tx.begin();
//		em.persist(auto);
//		tx.commit();
//
//		em.close();
//    }
//}
