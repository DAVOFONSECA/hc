/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Deudores;
import Entity.EntidadesDeudores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class DeudoresFacade extends AbstractFacade<Deudores> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeudoresFacade() {
        super(Deudores.class);
    }
    
    
    public List<EntidadesDeudores> traerEntidadesDeudores() {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `entidades_deudores`", EntidadesDeudores.class);
        return q.getResultList();
    }

    public Deudores encontrarDeudor(String tipo, int identificacion) {
        Query q = getEntityManager().createNativeQuery("Select * from deudores where tipoIdentificacion = ? and identificacion = ?", Deudores.class);
        q.setParameter(1, tipo);
        q.setParameter(2, identificacion);
        return (Deudores) q.getSingleResult();
    }
}
