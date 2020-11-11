/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.OrdenCompraRepuesto;
import kll.modelo.dao.IOrdenCompraRepuestoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class OrdenCompraRepuestoDAO extends AbstractDAO<OrdenCompraRepuesto> implements IOrdenCompraRepuestoDAO {

    public OrdenCompraRepuestoDAO() {
        super(OrdenCompraRepuesto.class);
    }
    
}
