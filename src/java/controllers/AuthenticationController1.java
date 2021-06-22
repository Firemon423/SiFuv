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
import sifuvfinal.ClienteFacade;
import sifuvfinal.Cliente;

/**
 *
 * @author USUARIO
 */
@ManagedBean(name = "authenticationController1")
@RequestScoped
public class AuthenticationController1 {

    @EJB
    private ClienteFacade clienteFacade;
    private String correo;
    private String password;
    private String message;

    @PostConstruct
    public void init() {
        message = "";
    }
    
    /**
     * Creates a new instance of AuthenticationController1
     */
    public AuthenticationController1() {
    }

    public String authentication() {
        System.out.println(correo + "-" + password);
        Cliente cliente = clienteFacade.isUserExistByCorreoAndPassword(correo, password);
        if (cliente != null) {
            
                  return "producto/List";
            
                
            } else {
              setMessage("¡El correo o contraseña son incorrectos!");
                
            }
        return "iniciar2";
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

