/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Deudores;
import Entity.Telefonos;
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
public class TelefonosFacade extends AbstractFacade<Telefonos> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonosFacade() {
        super(Telefonos.class);
    }
    
    public List<Telefonos> traerTodoslosTefonosDeUnDeudor(Deudores d) {
        Query q = getEntityManager().createNativeQuery("select * from telefonos where idDeudor = ?  order by estado, intentosEfectivos desc", Telefonos.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public List<Telefonos> traerTelefonosActivosDeudor(Deudores d) {
        Query q = getEntityManager().createNativeQuery("select * from telefonos where idDeudor = ? and estado = 'ACTIVO' order by intentosEfectivos desc", Telefonos.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public Telefonos traerTelefonos(Deudores d, String telefono) {

        Query q = getEntityManager().createNativeQuery("select * from telefonos where idDeudor = ? and telefono = ?", Telefonos.class);
        q.setParameter(1, d.getIdDeudor());
        q.setParameter(2, telefono);
        return (Telefonos) q.getSingleResult();
    }
}
