/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Actuacionessolicitudes;
import Entity.Solicitudes;
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
public class ActuacionessolicitudesFacade extends AbstractFacade<Actuacionessolicitudes> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActuacionessolicitudesFacade() {
        super(Actuacionessolicitudes.class);
    }
    
        public List<Actuacionessolicitudes> traerActaciones(Solicitudes u) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `actuacionessolicitudes` WHERE idsolicitud = ? order by fechaGestion desc", Actuacionessolicitudes.class);
        q.setParameter(1, u.getIdSolicitud());
        return q.getResultList();
    }
}
