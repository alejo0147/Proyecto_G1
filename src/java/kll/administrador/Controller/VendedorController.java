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
import kll.modelo.dao.IVendedorDAO;
import kll.modelo.entities.Vendedor;

/**
 *
 * @author alejo
 */
@Named(value = "vendedorController")
@ViewScoped
public class VendedorController implements Serializable{

    @EJB
    
    private IVendedorDAO vnddrDAO;
    
    private List<Vendedor> vendedores;
    
    private Vendedor vendedorSeleccionado;
    
    /**
     * Creates a new instance of VendedorController
     */
    public VendedorController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public List<Vendedor> getVendedores() {
        if (vendedores == null || vendedores.isEmpty()) {
            vendedores = vnddrDAO.findAll();
        }
        return vendedores;
    }

    public Vendedor getVendedorSeleccionado() {
        return vendedorSeleccionado;
    }

    public void setVendedorSeleccionado(Vendedor vendedorSeleccionado) {
        this.vendedorSeleccionado = vendedorSeleccionado;
    }
    
    public void seleccionarVendedor(Vendedor vnddr){
        this.vendedorSeleccionado = vnddr;
    }
}
