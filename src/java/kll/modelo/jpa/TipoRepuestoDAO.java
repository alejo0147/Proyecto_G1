/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.TipoRepuesto;
import kll.modelo.dao.ITipoRepuestoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class TipoRepuestoDAO extends AbstractDAO<TipoRepuesto> implements ITipoRepuestoDAO {

    public TipoRepuestoDAO() {
        super(TipoRepuesto.class);
    }
    
}
