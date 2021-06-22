/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifuvfinal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author USUARIO
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "SifuvFinalProyectPU")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente isUserExistByCorreoAndPassword(String correo, String password) {
        try {
            query = em.createQuery("SELECT u FROM Cliente u WHERE u.correo = :correo AND u.contraseña = :password");
            query.setParameter("correo", correo);
            query.setParameter("password", password);
            return (Cliente) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
