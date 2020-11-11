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
import kll.modelo.dao.IPqrsDAO;
import kll.modelo.entities.Pqrs;

/**
 *
 * @author alejo
 */
@Named(value = "pqrsController")
@ViewScoped
public class PqrsController implements Serializable {

    @EJB

    private IPqrsDAO pqrsDAO;

    private List<Pqrs> pqrs;

    private Pqrs pqrsSeleccionada;

    private Pqrs nuevaPqrs;

    public PqrsController(IPqrsDAO pqrsDAO, List<Pqrs> pqrs, Pqrs pqrsSeleccionada) {
        this.pqrsDAO = pqrsDAO;
        this.pqrs = pqrs;
        this.pqrsSeleccionada = pqrsSeleccionada;
    }

    /**
     * Creates a new instance of PqrsController
     */
    public PqrsController() {
    }

    @PostConstruct
    public void init() {

    }

    public List<Pqrs> getPqrs() {
        if (pqrs == null || pqrs.isEmpty()) {
            pqrs = pqrsDAO.findAll();
        }
        return pqrs;
    }

    public Pqrs getPqrsSeleccionada() {
        return pqrsSeleccionada;
    }

    public void setPqrsSeleccionada(Pqrs pqrsSeleccionada) {
        this.pqrsSeleccionada = pqrsSeleccionada;
    }

    public Pqrs getNuevaPqrs() {
        return nuevaPqrs;
    }

    public void setNuevaPqrs(Pqrs nuevaPqrs) {
        this.nuevaPqrs = nuevaPqrs;
    }
    
    public void seleccionarPqrs(Pqrs pq) {
        this.pqrsSeleccionada = pq;
    }

}
