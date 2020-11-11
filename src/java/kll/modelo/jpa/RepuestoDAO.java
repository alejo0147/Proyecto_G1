/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Repuesto;
import kll.modelo.dao.IRepuestoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class RepuestoDAO extends AbstractDAO<Repuesto> implements IRepuestoDAO {

    public RepuestoDAO() {
        super(Repuesto.class);
    }
    
}
