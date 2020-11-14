/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.dao;

import javax.ejb.Local;
import kll.modelo.entities.Usuario;

/**
 *
 * @author alejo
 */
@Local
public interface IUsuarioDAO extends DAO<Usuario>{
    
    Usuario findByEmailAndPassword(String email, String password);
}
