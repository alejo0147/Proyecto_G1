/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Despacho;
import kll.modelo.dao.IDespachoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class DespachoDAO extends AbstractDAO<Despacho> implements IDespachoDAO {

    public DespachoDAO() {
        super(Despacho.class);
    }
    
}
