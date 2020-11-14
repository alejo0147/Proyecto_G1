/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.administrador.Controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import kll.modelo.dao.IUsuarioDAO;
import kll.modelo.entities.Usuario;
import kll.util.MessageUtil;

/**
 *
 * @author alejo
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    @EJB
    private IUsuarioDAO uDAO;

    private String email;
    private String password;
    private Usuario user;

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String inciarSesion() {
        if (email != null && email.trim().length() > 0
                && password != null && password.trim().length() > 0) {
            user = uDAO.findByEmailAndPassword(email, password);
            if (user != null) {
                return "/app/administrador/admin_modulo.xhtml?faces-redirect=true";
            } else {
                MessageUtil.sendInfo(null, "Datos incorrectos.", "¡Correo o contraseña invalidos!", Boolean.FALSE);
            }
        } else {
            MessageUtil.sendInfo(null, "Datos obligatorios", "Debe diligenciar todos los campos", Boolean.FALSE);
        }
        return "";
    }
    
    public boolean sesionIniciada(){
        return user != null;
    }
    
    public void validarSesion() throws IOException{
        if(!sesionIniciada()){
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(ec.getRequestContextPath());
        }
    }
    
}
