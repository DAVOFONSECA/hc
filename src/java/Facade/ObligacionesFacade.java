/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Deudores;
import Entity.Garantias;
import Entity.Obligaciones;
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
public class ObligacionesFacade extends AbstractFacade<Obligaciones> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObligacionesFacade() {
        super(Obligaciones.class);
    }
    
    
    public List<Obligaciones> traerObligacionesDeudor(Deudores d) {
        Query q = getEntityManager().createNativeQuery("SELECT o.* FROM `obligaciones` as o \n"
                + "inner JOIn deudores_obligaciones as do on \n"
                + "do.idObligacion = o.idObligacion\n"
                + "inner join deudores as d on \n"
                + "d.idDeudor = do.idDeudor\n"
                + "where d.idDeudor = ? order by saldoCapital desc", Obligaciones.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public List<Obligaciones> traerObligacionesDeudorSinAcuerdos(Deudores d) {
        Query q = getEntityManager().createNativeQuery("SELECT o.* FROM obligaciones as o \n"
                + "inner join deudores_obligaciones as do on \n"
                + "do.idObligacion= o.idObligacion\n"
                + "inner join deudores as d on \n"
                + "d.idDeudor=do.idDeudor\n"
                + "where d.idDeudor = ? and \n"
                + "o.idObligacion not in ( SELECT DISTINCT(ob.idObligacion) FROM `obligaciones` as ob inner join acuerdos as a on a.idObligacion=ob.idObligacion where a.estado in (\"VIGENTE\",\"EN MORA\"))", Obligaciones.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public List<Garantias> traerGarantiasDeLasOligaciones(Obligaciones o) {
        Query q = getEntityManager().createNativeQuery("select g.* from garantias as g \n"
                + "inner join obligaciones_garantias as ob on \n"
                + "ob.idGarantia = g.idGarantia \n"
                + "inner join obligaciones as b on \n"
                + "ob.idObligacion=b.idObligacion\n"
                + "WHERE b.numero = ?", Garantias.class);
        q.setParameter(1, o.getNumero());
        return q.getResultList();
    }

    public List<Garantias> traerTiposGarantiasDeudor(Deudores d) {
        Query q = getEntityManager().createNativeQuery("select * from garantias as g \n"
                + "inner join obligaciones_garantias as og on og.idGarantia=g.idGarantia \n"
                + "inner join obligaciones as o on o.idObligacion=og.idObligacion \n"
                + "inner join deudores_obligaciones as do on do.idObligacion = o.idObligacion \n"
                + "inner join deudores as d on d.idDeudor=do.idDeudor \n"
                + "WHERE d.idDeudor = ? ", Garantias.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }
}
