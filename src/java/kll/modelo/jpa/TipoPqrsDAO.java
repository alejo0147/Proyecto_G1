/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.TipoPqrs;
import kll.modelo.dao.ITipoPqrsDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class TipoPqrsDAO extends AbstractDAO<TipoPqrs> implements ITipoPqrsDAO {

    public TipoPqrsDAO() {
        super(TipoPqrs.class);
    }
    
}
