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
import kll.modelo.dao.IVendedorDAO;
import kll.modelo.entities.Vendedor;

/**
 *
 * @author alejo
 */
@FacesConverter(forClass = Vendedor.class)
public class VendedorConverter implements Converter{

    private IVendedorDAO vddrDao;

    public VendedorConverter() {
        vddrDao = CDI.current().select(IVendedorDAO.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {  
        if (value != null) {
            try {
                Integer id = Integer.valueOf(value);
                return vddrDao.find(id);
            } catch (NumberFormatException numberFormatException) {
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object obj) {
        if (obj != null && obj instanceof Vendedor ) {
           Vendedor vddr = (Vendedor)obj; 
            return vddr.getId().toString();
        }
        return "";
    }
    
}
