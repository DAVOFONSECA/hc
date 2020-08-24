/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Juzgados;
import Entity.JuzgadosProcesos;
import Entity.Procesos;
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
public class JuzgadosFacade extends AbstractFacade<Juzgados> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuzgadosFacade() {
        super(Juzgados.class);
    }

    public List<Usuarios> encontrarDependientes() {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `usuarios` WHERE rol = 'DEPENDIENTE'", Usuarios.class);
        return q.getResultList();
    }

    public List<JuzgadosProcesos>  encontrarJuzgadosDeUnProceso(Procesos p) {
        Query q = getEntityManager().createNativeQuery("Select * From juzgados_procesos where idProceso = ? order by fechaIngreso DESC", JuzgadosProcesos.class);
        q.setParameter(1, p.getIdProceso());
        return q.getResultList();
    }

    public List<Juzgados> encontrarJuzgados() {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `juzgados` ORDER by numero, codigoClase, idCiudad", Juzgados.class);
        return q.getResultList();
    }

    public Juzgados encontrarElJuzgadoActualDeUnProceso(Procesos p) {
        Query q = getEntityManager().createNativeQuery("Select * From juzgados_procesos where idProceso = ? and idRelacion in (SELECT MAX(idRelacion) FROM `juzgados_procesos`)", Juzgados.class);
        q.setParameter(1, p.getIdProceso());
        return (Juzgados) q.getSingleResult();
    }

    public Juzgados juzgadoOrigen(Procesos u) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `juzgados_procesos` WHERE observacion = 'JUZGADO DE ORIGEN' AND idProceso = ?", Juzgados.class);
        return (Juzgados) q.getSingleResult();
    }

    public List<JuzgadosProcesos> juzgadosAnteriores(Procesos u) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM juzgados_procesos where idProceso = ? order by desc ", JuzgadosProcesos.class);
        q.setParameter(1, u.getIdProceso());
        return q.getResultList();
    }

}
