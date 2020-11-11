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
import kll.modelo.dao.IRolDAO;
import kll.modelo.entities.Rol;

/**
 *
 * @author alejo
 */
@FacesConverter(forClass = Rol.class)
public class RolConverter implements Converter{
    
    private IRolDAO rlDAO;

    public RolConverter() {
        rlDAO = CDI.current().select(IRolDAO.class).get();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            try {
                Integer id = Integer.valueOf(value);
                return rlDAO.find(id);
            } catch (NumberFormatException numberFormatException) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object obj) {
        if (obj != null && obj instanceof Rol) {
            Rol rl = (Rol) obj;
            return rl.getId().toString();
        }
        return "";
    }
    
}
