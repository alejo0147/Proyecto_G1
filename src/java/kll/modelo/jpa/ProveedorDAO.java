/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Proveedor;
import kll.modelo.dao.IProveedorDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class ProveedorDAO extends AbstractDAO<Proveedor> implements IProveedorDAO {

    public ProveedorDAO() {
        super(Proveedor.class);
    }
    
}
