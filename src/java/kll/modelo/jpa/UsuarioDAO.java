/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Usuario;
import kll.modelo.dao.IUsuarioDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario> implements IUsuarioDAO {

    public UsuarioDAO() {
        super(Usuario.class);
    }
    
}
