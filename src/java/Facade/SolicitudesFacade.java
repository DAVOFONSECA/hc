/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Solicitudes;
import Entity.Usuarios;
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
public class SolicitudesFacade extends AbstractFacade<Solicitudes> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudesFacade() {
        super(Solicitudes.class);
    }

    public List<Solicitudes> traerTodosLasSolicitudes() {
        Query q = getEntityManager().createNativeQuery("select * from solicitudes order by idSolicitud desc", Solicitudes.class);
        return q.getResultList();
    }

    public List<Solicitudes> traerSolicitudesQueDeboResolver(Usuarios u) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `solicitudes` WHERE estado not in (\"FINALIZADA\",\"DESISTIDA\",\"RESUELTA\",\"DEVUELTA\") and idSolicitado = ? order by idSolicitud desc", Solicitudes.class);
        q.setParameter(1, u.getIdUsuario());
        return q.getResultList();
    }

    public List<Solicitudes> traerSolicitudesQueEscale(Usuarios u) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `solicitudes` WHERE estado not in (\"FINALIZADA\",\"DESISTIDA\",\"RESUELTA\",\"DEVUELTA\") and idSolicitante = ? order by idSolicitud desc", Solicitudes.class);
        q.setParameter(1, u.getIdUsuario());
        return q.getResultList();
    }

    public List<Solicitudes> traerSolicitudesDevueltas(Usuarios u) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `solicitudes` WHERE estado in ('DEVUELTA') and idSolicitante = ? order by idSolicitud desc", Solicitudes.class);
        q.setParameter(1, u.getIdUsuario());
        return q.getResultList();
    }
}
