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
import kll.modelo.dao.IRolDAO;
import kll.modelo.entities.Rol;

/**
 *
 * @author alejo
 */
@Named(value = "rolController")
@RequestScoped
public class RolController implements Serializable{
    
    @EJB
    private IRolDAO rlDAO;
    
    private List<Rol> roles;
    
    private Rol rolSeleccionado;
    
    private Rol nuevoRol;

    /**
     * Creates a new instance of RolController
     */
    public RolController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<Rol> getRoles() {
        if (roles == null || roles.isEmpty()) {
           roles = rlDAO.findAll();
        }
        return roles;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public Rol getNuevoRol() {
        return nuevoRol;
    }

    public void setNuevoRol(Rol nuevoRol) {
        this.nuevoRol = nuevoRol;
    }
    
    public void seleccionarRol(Rol rl){
        this.rolSeleccionado = rl;
    }
    
    public void registrar() {
        try {
            System.out.println("Id: " + nuevoRol.getId());
            rlDAO.create(nuevoRol);
        } catch (Exception ex) {
        }
    }
}
