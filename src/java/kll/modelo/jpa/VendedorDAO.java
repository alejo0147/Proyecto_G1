/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Vendedor;
import kll.modelo.dao.IVendedorDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class VendedorDAO extends AbstractDAO<Vendedor> implements IVendedorDAO {
    public VendedorDAO() {
        super(Vendedor.class);
    }
    
}
