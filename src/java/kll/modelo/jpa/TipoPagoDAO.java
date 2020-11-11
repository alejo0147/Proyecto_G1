/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.TipoPago;
import kll.modelo.dao.ITipoPagoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class TipoPagoDAO extends AbstractDAO<TipoPago> implements ITipoPagoDAO {

    public TipoPagoDAO() {
        super(TipoPago.class);
    }
    
}
