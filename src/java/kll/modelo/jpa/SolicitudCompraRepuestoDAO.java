/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.jpa;

import javax.ejb.Stateless;
import kll.modelo.entities.SolicitudCompraRepuesto;
import kll.modelo.dao.ISolicitudCompraRepuestoDAO;

/**
 *
 * @author alejo
 */
@Stateless
public class SolicitudCompraRepuestoDAO extends AbstractDAO<SolicitudCompraRepuesto> implements ISolicitudCompraRepuestoDAO {

    public SolicitudCompraRepuestoDAO() {
        super(SolicitudCompraRepuesto.class);
    }
    
}
