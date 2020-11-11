/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.converters;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import kll.modelo.dao.ISolicitudCompraRepuestoDAO;
import kll.modelo.entities.SolicitudCompraRepuesto;

/**
 *
 * @author alejo
 */
@FacesConverter(forClass = SolicitudCompraRepuesto.class)
public class SolicitudCRConverter implements Converter{
    
    private ISolicitudCompraRepuestoDAO scrDAO;

    public SolicitudCRConverter() {
        scrDAO = CDI.current().select(ISolicitudCompraRepuestoDAO.class).get();
    }
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       if (value != null) {
            try {
                Integer id = Integer.valueOf(value);
                return scrDAO.find(id);
            } catch (NumberFormatException numberFormatException) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof SolicitudCompraRepuesto) {
            SolicitudCompraRepuesto solicitudCR = (SolicitudCompraRepuesto)value;
            return solicitudCR.getId().toString();
        }
        return "";
    }
    
}
