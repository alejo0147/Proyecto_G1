/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.administrador.Controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import kll.modelo.dao.ITipoPagoDAO;
import kll.modelo.entities.TipoPago;

/**
 *
 * @author alejo
 */
@Named(value = "tipoPagoController")
@ViewScoped
public class TipoPagoController implements Serializable{

    @EJB
    
    private ITipoPagoDAO tpagoDAO;
    
    private List<TipoPago> tiposdePago;
    
    private TipoPago tipoPagoSeleccionado;
    
    private TipoPago nuevoTipoPago;
    /**
     * Creates a new instance of TipoPagoController
     */
    public TipoPagoController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<TipoPago> getTiposdePago() {
        return tiposdePago;
    }

    public TipoPago getTipoPagoSeleccionado() {
        return tipoPagoSeleccionado;
    }

    public void setTipoPagoSeleccionado(TipoPago tipoPagoSeleccionado) {
        this.tipoPagoSeleccionado = tipoPagoSeleccionado;
    }

    public TipoPago getNuevoTipoPago() {
        return nuevoTipoPago;
    }

    public void setNuevoTipoPago(TipoPago nuevoTipoPago) {
        this.nuevoTipoPago = nuevoTipoPago;
    }
    
    public void seleccionarTipoPago(TipoPago tPago){
        this.tipoPagoSeleccionado = tPago;
    }
}
