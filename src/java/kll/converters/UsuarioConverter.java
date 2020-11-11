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
import kll.modelo.dao.IUsuarioDAO;
import kll.modelo.entities.Usuario;

/**
 *
 * @author alejo
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{
    
    private IUsuarioDAO uDAO;

    public UsuarioConverter() {
        uDAO = CDI.current().select(IUsuarioDAO.class).get();
    }
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      if (value != null) {
            try {
                Integer id = Integer.valueOf(value);
                return uDAO.find(id);
            } catch (NumberFormatException numberFormatException) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Usuario) {
            Usuario usu = (Usuario)value;
             return usu.getId().toString();
        }
        return "";
    }
    
}
