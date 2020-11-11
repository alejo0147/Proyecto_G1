/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Administrador;
import kll.modelo.dao.IAdministradorDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class AdministradorDAO extends AbstractDAO<Administrador> implements IAdministradorDAO {

    public AdministradorDAO() {
        super(Administrador.class);
    }
    
}
