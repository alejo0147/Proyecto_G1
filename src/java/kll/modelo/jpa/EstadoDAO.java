/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Estado;
import kll.modelo.dao.IEstadoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class EstadoDAO extends AbstractDAO<Estado> implements IEstadoDAO {

    public EstadoDAO() {
        super(Estado.class);
    }
    
}
