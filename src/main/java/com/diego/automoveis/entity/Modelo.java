/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diego.automoveis.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author diego
 * Created on : Aug 15, 2020, 10:36:29 PM
 */
@Entity
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "seq_modelo", sequenceName = "seq_modelo")
@Table(name = "modelo")
public class Modelo implements Serializable {

	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_modelo")
    private int id;
	
	@Column(name="descricao", length = 300)
	private String descricao;
	
	@Column(name="potencia")
	private int potencia;
	
	@JoinColumn(name = "marca_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "modelo_marca_fk"))
    @ManyToOne(fetch = FetchType.LAZY)
	private Marca montadora;

	
	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public Marca getMarca() {
		return montadora;
	}

	public void setMarca(Marca marca) {
		this.montadora = marca;
	}

	// Equals & HashCode
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 19 * hash + this.id;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Modelo other = (Modelo) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.potencia != other.potencia) {
			return false;
		}
		if (!Objects.equals(this.descricao, other.descricao)) {
			return false;
		}
		if (!Objects.equals(this.montadora, other.montadora)) {
			return false;
		}
		return true;
	}
}
