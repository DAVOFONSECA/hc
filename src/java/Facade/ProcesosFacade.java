/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Deudores;
import Entity.Entidades;
import Entity.Procesos;
import Entity.ProcesosDemandados;
import Entity.ProcesosDemandantes;
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
public class ProcesosFacade extends AbstractFacade<Procesos> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesosFacade() {
        super(Procesos.class);
    }

    public Procesos encontrarProceso(Procesos u) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `procesos` WHERE idProceso = ?", Procesos.class);
        q.setParameter(1, u.getIdProceso());
        return (Procesos) q.getSingleResult();
    }

    public Procesos utProceso() {
        Procesos procesos = new Procesos();
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `procesos` WHERE idProceso in (SELECT max(idProceso) FROM `procesos`)", Procesos.class);
        return (Procesos) q.getSingleResult();
    }

    public List<ProcesosDemandados> encontrarDemandados(Procesos u) {
        Query q = getEntityManager().createNativeQuery("SELECT pd.* FROM `procesos_demandados` as pd inner join deudores as d on d.idDeudor=pd.idDeudor WHERE pd.idProceso = ?", ProcesosDemandados.class);
        q.setParameter(1, u.getIdProceso());
        return q.getResultList();
    }

    public List<ProcesosDemandantes> encontrarDemandantes(Procesos u) {
        Query q = getEntityManager().createNativeQuery("SELECT pd.* FROM `procesos_demandantes` as pd inner join entidades as e on e.idEntidad=pd.idEntidad WHERE pd.idProceso = ?", ProcesosDemandantes.class);
        q.setParameter(1, u.getIdProceso());
        return q.getResultList();
    }

}
