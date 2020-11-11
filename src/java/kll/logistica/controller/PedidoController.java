/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.logistica.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import kll.modelo.dao.IPedidoDAO;
import kll.modelo.entities.Pedido;

/**
 *
 * @author alejo
 */
@Named(value = "pedidoController")
@ViewScoped
public class PedidoController implements Serializable{
  
    @EJB
    
    private IPedidoDAO pddDAO;
    
    private List<Pedido> pedidos;
    
    private Pedido pedidoSeleccionado;
    
    private Pedido nuevoPedido;
    /**
     * Creates a new instance of PedidoController
     */
    public PedidoController() {
    }
    
    @PostConstruct
    public void init(){
        
    }

    public List<Pedido> getPedidos() {
        if (pedidos == null || pedidos.isEmpty()) {
            pedidos = pddDAO.findAll();
        }
        return pedidos;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
    }

    public Pedido getNuevoPedido() {
        return nuevoPedido;
    }

    public void setNuevoPedido(Pedido nuevoPedido) {
        this.nuevoPedido = nuevoPedido;
    }
    
    public void seleccionarPedido(Pedido pdd){
        this.pedidoSeleccionado = pdd;
    }
    
}
