/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diego.automoveis.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author diego
 * Created on : Aug 15, 2020, 10:36:29 PM
 */
@Entity
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "seq_marca", sequenceName = "seq_marca")
@Table(name = "marca")
public class Marca implements Serializable {

	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca")
    private int id;
	
	@Column(name="nome", length = 50)
	private String nome;	
	
	@OneToMany(mappedBy="montadora") //LAZY por padrão
	private List<Modelo> modelos;
	
}
