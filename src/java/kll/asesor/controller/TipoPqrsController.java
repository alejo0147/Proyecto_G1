/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.asesor.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import kll.modelo.dao.ITipoPqrsDAO;
import kll.modelo.entities.TipoPqrs;

/**
 *
 * @author alejo
 */
@Named(value = "tipoPqrsController")
@ViewScoped
public class TipoPqrsController implements Serializable{

    @EJB
    
    private ITipoPqrsDAO tPqrsDAO;
    
    private List<TipoPqrs> tiposPqrs;
    
    private TipoPqrs tipoPqrsSeleccionada;
    
    private TipoPqrs nuevoTipoPqrs;
    /**
     * Creates a new instance of TipoPqrsController
     */
    public TipoPqrsController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<TipoPqrs> getTiposPqrs() {
        if (tiposPqrs == null || tiposPqrs.isEmpty()) {
            tiposPqrs = tPqrsDAO.findAll();
        }
        return tiposPqrs;
    }

    public TipoPqrs getTipoPqrsSeleccionada() {
        return tipoPqrsSeleccionada;
    }

    public void setTipoPqrsSeleccionada(TipoPqrs tipoPqrsSeleccionada) {
        this.tipoPqrsSeleccionada = tipoPqrsSeleccionada;
    }

    public TipoPqrs getNuevoTipoPqrs() {
        return nuevoTipoPqrs;
    }

    public void setNuevoTipoPqrs(TipoPqrs nuevoTipoPqrs) {
        this.nuevoTipoPqrs = nuevoTipoPqrs;
    }
    
    public void seleccionarTipoPqrs(TipoPqrs tPqrs){
        this.tipoPqrsSeleccionada = tPqrs;
    }
    
}
