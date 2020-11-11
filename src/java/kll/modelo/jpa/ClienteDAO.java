/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Cliente;
import kll.modelo.dao.IClienteDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class ClienteDAO extends AbstractDAO<Cliente> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }
    
}
