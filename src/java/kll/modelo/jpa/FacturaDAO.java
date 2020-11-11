/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Factura;
import kll.modelo.dao.IFacturaDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class FacturaDAO extends AbstractDAO<Factura> implements IFacturaDAO {

    public FacturaDAO() {
        super(Factura.class);
    }
    
}
