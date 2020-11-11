/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Pedido;
import kll.modelo.dao.IPedidoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class PedidoDAO extends AbstractDAO<Pedido> implements IPedidoDAO {

    public PedidoDAO() {
        super(Pedido.class);
    }
    
}
