/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Rol;
import kll.modelo.dao.IRolDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class RolDAO extends AbstractDAO<Rol> implements IRolDAO {

    public RolDAO() {
        super(Rol.class);
    }
    
}
