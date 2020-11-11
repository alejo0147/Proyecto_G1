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
import kll.modelo.dao.IFacturaDAO;
import kll.modelo.entities.Factura;

/**
 *
 * @author alejo
 */
@Named(value = "facturasController")
@ViewScoped
public class FacturasController implements Serializable{
    
    @EJB
    private IFacturaDAO fctDAO;
    
    private List<Factura> facturas;
    
    private Factura facturaSeleccionada;
    
    private Factura nuevaFactura;

    /**
     * Creates a new instance of FacturasController
     */
    public FacturasController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<Factura> getFacturas() {
        if (facturas == null || facturas.isEmpty()) {
            facturas = fctDAO.findAll();
        }
        return facturas;
    }
     public Factura getFacturaSeleccionada() {
        return facturaSeleccionada;
    }

    public void setFacturaSeleccionada(Factura facturaSeleccionada) {
        this.facturaSeleccionada = facturaSeleccionada;
    }

    public Factura getNuevaFactura() {
        return nuevaFactura;
    }

    public void setNuevaFactura(Factura nuevaFactura) {
        this.nuevaFactura = nuevaFactura;
    }
    

  public void  seleccionarFactura(Factura fct){
      System.out.println("la ha seleccionado la factura");
      System.out.println(fct);
        this.facturaSeleccionada = fct;
    }
    
  public void registrar() {
        try {
            System.out.println("Id: " + nuevaFactura.getId());
            nuevaFactura.setEstado(Short.valueOf("5"));
            fctDAO.create(nuevaFactura);
        } catch (Exception ex) {
        }
    }
}
