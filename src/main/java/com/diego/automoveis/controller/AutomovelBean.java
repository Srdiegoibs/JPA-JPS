/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diego.automoveis.controller;

import com.diego.automoveis.entity.Automovel;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author diego
 */
@ManagedBean
public class AutomovelBean {
    private Automovel automovel = new Automovel();

    // getter e setter
    public void salva() {
        System.out.println("Marca: " + automovel.getMarca());
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(final Automovel automovel) {
        this.automovel = automovel;
    }
}