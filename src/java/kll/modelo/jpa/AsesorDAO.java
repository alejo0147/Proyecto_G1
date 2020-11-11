/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.Asesor;
import kll.modelo.dao.IAsesorDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class AsesorDAO extends AbstractDAO<Asesor> implements IAsesorDAO {

    public AsesorDAO() {
        super(Asesor.class);
    }
    
}
