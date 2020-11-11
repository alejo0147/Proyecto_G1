/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Logistica;
import kll.modelo.dao.ILogisticaDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class LogisticaDAO extends AbstractDAO<Logistica> implements ILogisticaDAO {

    public LogisticaDAO() {
        super(Logistica.class);
    }
    
}
