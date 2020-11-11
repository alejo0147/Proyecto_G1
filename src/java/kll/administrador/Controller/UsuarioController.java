/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.administrador.Controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import kll.modelo.dao.IUsuarioDAO;
import kll.modelo.entities.Usuario;
import kll.util.MessageUtil;

/**
 *
 * @author alejo
 */
@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable{
    
    @EJB
    private IUsuarioDAO uDAO;
    
    private List<Usuario> usuarios;
    
    private Usuario usuarioSeleccionado;
    
    private Usuario nuevoUsuario;

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }
    
    @PostConstruct
    public void init(){
        nuevoUsuario = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null || usuarios.isEmpty()) {
            usuarios = uDAO.findAll();
        }
        return usuarios;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }
    
    public void seleccionarUsuario(Usuario u) {
        System.out.println("Se ha seleccionado el usuario");
        System.out.println(u);
        this.usuarioSeleccionado = u;
    }
    
    public void registrar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            uDAO.create(nuevoUsuario);
            MessageUtil.sendInfo(null, "Registro de usuario exitoso", "", false);
        } catch (Exception ex) {
            MessageUtil.sendError(null, "Error al registrar usuario", ex.getMessage(), false);
        }
    }
}
