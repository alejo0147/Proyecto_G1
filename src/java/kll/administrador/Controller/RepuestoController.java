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
import kll.modelo.dao.IRepuestoDAO;
import kll.modelo.entities.Repuesto;

/**
 *
 * @author alejo
 */
@Named(value = "repuestoController")
@ViewScoped
public class RepuestoController implements Serializable{

    @EJB
    private IRepuestoDAO rpstDAO;
    
    private List<Repuesto> repuestos;
    
    private Repuesto repuestoSeleccionado;
    
    private Repuesto nuevoRepuesto;
    /**
     * Creates a new instance of RepuestoController
     */
    public RepuestoController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<Repuesto> getRepuestos() {
        if (repuestos == null || repuestos.isEmpty()) {
          repuestos = rpstDAO.findAll();
        }
        return repuestos;
    }

    public Repuesto getRepuestoSeleccionado() {
        return repuestoSeleccionado;
    }

    public void setRepuestoSeleccionado(Repuesto repuestoSeleccionado) {
        this.repuestoSeleccionado = repuestoSeleccionado;
    }

    public Repuesto getNuevoRepuesto() {
        return nuevoRepuesto;
    }

    public void setNuevoRepuesto(Repuesto nuevoRepuesto) {
        this.nuevoRepuesto = nuevoRepuesto;
    }
    
    public void seleccionarRepuesto (Repuesto repst){
        this.repuestoSeleccionado = repst;
    }
    
    public void registrar() {
        try {
            System.out.println("Id: " + nuevoRepuesto.getId());
            rpstDAO.create(nuevoRepuesto);
        } catch (Exception ex) {
        }
    }
}
