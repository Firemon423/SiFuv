/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import sifuvfinal.UsuariosFacade;
import sifuvfinal.Usuarios;

/**
 *
 * @author USUARIO
 */
@ManagedBean(name = "authenticationController")
@RequestScoped
public class AuthenticationController {

    @EJB
    private UsuariosFacade usuarioFacade;
    private String correo;
    private String password;
    private String message;

    @PostConstruct
    public void init() {
        message = "";
    }
    
    /**
     * Creates a new instance of AuthenticationController
     */
    public AuthenticationController() {
    }

    public String authentication() {
        Usuarios usuarios = usuarioFacade.isUserExistByCorreoAndPassword(getCorreo(), getPassword());
        if (usuarios != null) {
            if(usuarios.getIdRol().getNombreRol().equals("Administrador")) {
                return "inventario/List";
            } else if(usuarios.getIdRol().getNombreRol().equals("Cajero")) {
                return "ventas/Create";
            } else if(usuarios.getIdRol().getNombreRol().equals("Domiciliario")) {
                return "domicilios/List";
            } 
        } else {
            setMessage("¡El usuario o contraseña son incorrectos!");
        }
        return "iniciar";
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
