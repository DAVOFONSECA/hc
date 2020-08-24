/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Actuacionescartasvisitas;
import Entity.Cartasvisitas;
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
public class CartasvisitasFacade extends AbstractFacade<Cartasvisitas> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartasvisitasFacade() {
        super(Cartasvisitas.class);
    }
    
      public List<Cartasvisitas> traerCartasVisitasDireccion(Direcciones d) {
        Query q = getEntityManager().createNativeQuery("Select * from cartasvisitas where idDireccion = ? order by tipo", Cartasvisitas.class);
        q.setParameter(1, d.getIdDireccion());
        return q.getResultList();
    }

    public Cartasvisitas traerUltimaCartaVisita() {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `cartasvisitas` WHERE idCartasVisitas in (SELECT max(idCartasVisitas) FROM `cartasvisitas`)", Cartasvisitas.class);
        return (Cartasvisitas) q.getSingleResult();
    }

    public List<Actuacionescartasvisitas> traerCartasVisitasDireccion(Cartasvisitas d) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `actuacionescartasvisitas` WHERE idCartasVisitas = ? order by fechaActuacion desc; ", Actuacionescartasvisitas.class);
        q.setParameter(1, d.getIdCartasVisitas());
        return q.getResultList();
    }

    public String traerEntidad(Direcciones d) {
        Query q = getEntityManager().createNativeQuery("SELECT DISTINCT(e.nombre)\n"
                + "FROM `Direcciones` as dir \n"
                + "INNER JOIN deudores AS d on \n"
                + "d.idDeudor = dir.idDeudor \n"
                + "INNER JOIN deudores_obligaciones as do on \n"
                + "do.idDeudor= d.idDeudor\n"
                + "INNER JOIN obligaciones as o on \n"
                + "o.idObligacion = do.idObligacion \n"
                + "INNER JOIN entidades AS E ON \n"
                + "E.idEntidad = O.idEntidad\n"
                + "WHERE dir.idDireccion = ?");
        q.setParameter(1, d.getIdDireccion());
        return (String) q.getSingleResult();
    }
}
