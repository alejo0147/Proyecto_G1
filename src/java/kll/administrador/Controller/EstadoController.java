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
import javax.enterprise.context.RequestScoped;
import kll.modelo.dao.IEstadoDAO;
import kll.modelo.entities.Estado;

/**
 *
 * @author alejo
 */
@Named(value = "estadoController")
@RequestScoped
public class EstadoController implements Serializable{
    
    @EJB
    private IEstadoDAO estDAO;
    
    private List<Estado> estados;
    
    private Estado estadoSeleccionado;
    
    private Estado nuevoEstado;

    /**
     * Creates a new instance of EstadoController
     */
    public EstadoController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<Estado> getEstados() {
        if (estados == null || estados.isEmpty()) {
            estados = estDAO.findAll();
        }
        return estados;
    }

    public Estado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Estado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public Estado getNuevoEstado() {
        return nuevoEstado;
    }

    public void setNuevoEstado(Estado nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }
    
    public void seleccionarEstado(Estado est){
        this.estadoSeleccionado = est;
    }
    
    public void registrar() {
        try {
            System.out.println("Id: " + nuevoEstado.getId());
            estDAO.create(nuevoEstado);
        } catch (Exception ex) {
        }
    }
}
