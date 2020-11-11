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
import kll.modelo.dao.IProveedorDAO;
import kll.modelo.entities.Proveedor;

/**
 *
 * @author alejo
 */
@Named(value = "proveedorController")
@ViewScoped
public class ProveedorController implements Serializable{

    @EJB
    
    private IProveedorDAO pvdrDAO;
    
    private List<Proveedor> proveedores;
    
    private Proveedor proveedorSeleccionado;
    
    private Proveedor nuevoProveedor;
    /**
     * Creates a new instance of ProveedorController
     */
    public ProveedorController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<Proveedor> getProveedores() {
        if (proveedores == null || proveedores.isEmpty()) {
            proveedores = pvdrDAO.findAll();
        }
        return proveedores;
    }

    public Proveedor getProveedorSeleccionado() {
        return proveedorSeleccionado;
    }

    public void setProveedorSeleccionado(Proveedor proveedorSeleccionado) {
        this.proveedorSeleccionado = proveedorSeleccionado;
    }

    public Proveedor getNuevoProveedor() {
        return nuevoProveedor;
    }

    public void setNuevoProveedor(Proveedor nuevoProveedor) {
        this.nuevoProveedor = nuevoProveedor;
    }
    
    public void seleccionarProveedor(Proveedor pvdr){
        this.proveedorSeleccionado = pvdr;
    }
    
}
