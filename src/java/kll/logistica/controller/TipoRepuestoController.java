/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.logistica.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import kll.modelo.dao.ITipoRepuestoDAO;
import kll.modelo.entities.TipoRepuesto;

/**
 *
 * @author alejo
 */
@Named(value = "tipoRepuestoController")
@ViewScoped
public class TipoRepuestoController implements Serializable{
    
    @EJB
    
    private ITipoRepuestoDAO tRepuestoDAO;
    
    private List<TipoRepuesto> tiposRepuesto;
    
    private TipoRepuesto tipoRepuestoSeleccionado;
    
    private TipoRepuesto nuevoTipoRepuesto;

    /**
     * Creates a new instance of TipoRepuestoController
     */
    public TipoRepuestoController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<TipoRepuesto> getTiposRepuesto() {
        if (tiposRepuesto == null || tiposRepuesto.isEmpty()) {
            tiposRepuesto = tRepuestoDAO.findAll();
        }
        return tiposRepuesto;
    }

    public TipoRepuesto getTipoRepuestoSeleccionado() {
        return tipoRepuestoSeleccionado;
    }

    public void setTipoRepuestoSeleccionado(TipoRepuesto tipoRepuestoSeleccionado) {
        this.tipoRepuestoSeleccionado = tipoRepuestoSeleccionado;
    }

    public TipoRepuesto getNuevoTipoRepuesto() {
        return nuevoTipoRepuesto;
    }

    public void setNuevoTipoRepuesto(TipoRepuesto nuevoTipoRepuesto) {
        this.nuevoTipoRepuesto = nuevoTipoRepuesto;
    }
    
    public void seleccionarTipoRepuesto(TipoRepuesto tRepuesto){
        this.tipoRepuestoSeleccionado = tRepuesto;
    }
    
}
