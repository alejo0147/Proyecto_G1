/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.ventas.controller;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import kll.modelo.dao.IOrdenCompraRepuestoDAO;
import kll.modelo.entities.OrdenCompraRepuesto;

/**
 *
 * @author alejo
 */
@Named(value = "ordenesCompraRepuestoController")
@ViewScoped
public class OrdenesCompraRepuestoController implements Serializable{
    
    @EJB
    private IOrdenCompraRepuestoDAO ocrDAO;
    
    private List<OrdenCompraRepuesto> ordenesCR;
    
    private OrdenCompraRepuesto ordenSeleccionada;
    
    private OrdenCompraRepuesto nuevaOrden;

    /**
     * Creates a new instance of OrdenesCompraRepuestoController
     */
    public OrdenesCompraRepuestoController() {
    }
    
    @PostConstruct
    public void init(){
       nuevaOrden = new OrdenCompraRepuesto();
    }

    public List<OrdenCompraRepuesto> getOrdenesCR() {
        if (ordenesCR == null || ordenesCR.isEmpty()) {
            ordenesCR = ocrDAO.findAll();
        }
        return ordenesCR;
    }

    public OrdenCompraRepuesto getOrdenSeleccionada() {
        return ordenSeleccionada;
    }

    public void setOrdenSeleccionada(OrdenCompraRepuesto ordenSeleccionada) {
        this.ordenSeleccionada = ordenSeleccionada;
    }

    public OrdenCompraRepuesto getNuevaOrden() {
        return nuevaOrden;
    }

    public void setNuevaOrden(OrdenCompraRepuesto nuevaOrden) {
        this.nuevaOrden = nuevaOrden;
    }

    public void seleccionarOrden(OrdenCompraRepuesto ocr){
        this.ordenSeleccionada = ocr;
    }
    
    public void registrar() {
        FacesContext fc1 = FacesContext.getCurrentInstance();
        try {
            System.out.println("Id: " + nuevaOrden.getId());
            nuevaOrden.setId(ocrDAO.count()+1);
            nuevaOrden.setEstado(Short.valueOf("4"));
            ocrDAO.create(nuevaOrden);
        } catch (Exception exc1) {
            FacesMessage fm1 = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al registrar la Orden", exc1.getMessage());
            fc1.addMessage(null, fm1);
        }
    }
}
