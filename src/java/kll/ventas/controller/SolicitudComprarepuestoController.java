/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.ventas.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import kll.modelo.dao.ISolicitudCompraRepuestoDAO;
import kll.modelo.entities.SolicitudCompraRepuesto;

/**
 *
 * @author alejo
 */
@Named(value = "solicitudComprarepuestoController")
@ViewScoped
public class SolicitudComprarepuestoController implements Serializable{

    @EJB
    
    private ISolicitudCompraRepuestoDAO scrDAO;
    
    private List<SolicitudCompraRepuesto> solicitudesCR;
    
    /**
     * Creates a new instance of SolicitudComprarepuestoController
     */
    public SolicitudComprarepuestoController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<SolicitudCompraRepuesto> getSolicitudesCR() {
        if (solicitudesCR == null || solicitudesCR.isEmpty()) {
            solicitudesCR = scrDAO.findAll();
        }
        return solicitudesCR;
    }
    
    
}
