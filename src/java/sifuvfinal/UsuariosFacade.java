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
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "SifuvFinalProyectPU")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public Usuarios isUserExistByCorreoAndPassword(String correo, String password) {
        try {
            query = em.createQuery("SELECT u FROM Usuarios u WHERE u.email = :correo AND u.contraseña = :password");
            query.setParameter("correo", correo);
            query.setParameter("password", password);
            return (Usuarios) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
