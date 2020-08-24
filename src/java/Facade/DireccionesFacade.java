/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Deudores;
import Entity.Direcciones;
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
public class DireccionesFacade extends AbstractFacade<Direcciones> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionesFacade() {
        super(Direcciones.class);
    }
    
        public List<Direcciones> traerTodosLasDireccionesFisicasDeUnDeudor(Deudores d) {
        Query q = getEntityManager().createNativeQuery("select * from direcciones where idDeudor = ? and tipo = 'FISICA' order by estado, intentosEfectivos desc", Direcciones.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public List<Direcciones> traerTodosLasDireccionesElectronicasDeUnDeudor(Deudores d) {
        Query q = getEntityManager().createNativeQuery("select * from direcciones where idDeudor = ? and tipo = 'EMAIL' order by estado, intentosEfectivos desc", Direcciones.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    
}
