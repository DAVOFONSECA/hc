/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Acuerdos;
import Entity.Cuotasacuerdos;
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
public class AcuerdosFacade extends AbstractFacade<Acuerdos> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcuerdosFacade() {
        super(Acuerdos.class);
    }
    
    
    public List<Acuerdos> traerCompromisosDeUnaObligaciones(Obligaciones o) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `acuerdos` where idObligacion = ? order by  idAcuerdo asc  ", Acuerdos.class);
        q.setParameter(1, o.getIdObligacion());
        return q.getResultList();
    }

    public int verificarCompromisosPrevios(Obligaciones o) {

        try {
            Query q = getEntityManager().createNativeQuery("SELECT DISTINCT(ESTADO) FROM `acuerdos` WHERE ESTADO = 'VIGENTE' AND idObligacion = ?");
            q.setParameter(1, o.getIdObligacion());
            if (q.getSingleResult().equals("VIGENTE")) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public Acuerdos traerUltimoAcuerdo() {
        Query q = getEntityManager().createNativeQuery("select * from acuerdos where idAcuerdo in(select max(idAcuerdo)  from acuerdos)",Acuerdos.class);
        return (Acuerdos) q.getSingleResult();
    }

    public List<Cuotasacuerdos> traerTodosLasCuotasDeUnCompromiso(Acuerdos c) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `Cuotasacuerdos` WHERE idAcuerdo = ? order by fechaCuota", Cuotasacuerdos.class);
        q.setParameter(1, c.getIdAcuerdo());
        return q.getResultList();

    }
    
}
