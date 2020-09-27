/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.automoveis.entity;

import com.diego.automoveis.validation.MaxAnoAtualMais;
import java.io.Serializable;
import javax.faces.convert.FacesConverter;
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
import javax.validation.constraints.Min;

/**
 *
 * @author diego
 */
@Entity
@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "seq_carro", sequenceName = "seq_carro")
@Table(name = "carros")
public class Automovel implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carro")
    private int id;
    
    @Column(name = "ano_fabricacao")
	@Min(1900) @MaxAnoAtualMais(message="O Valor máximo do ano de fabricação é {0}")
    private Integer anoFabricacao;
    
    @Column(name = "ano_modelo")
	@Min(1900) @MaxAnoAtualMais(message="O Valor máximo do ano de fabricação é {0}")
    private Integer anoModelo;
    
    @Column(name = "preco")
    private Float preco;
    
    @Column(name = "kilometragem")
    private Float kilometragem;
    
    @Column(name = "observacoes")
    private String observacoes;
    
    @JoinColumn(name = "modelo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "automovel_modelo_fk"))
	@ManyToOne(fetch = FetchType.LAZY)
    private Modelo modelo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Float kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}