/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Deudores;
import Entity.Gestionescomerciales;
import java.util.Date;
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
public class GestionescomercialesFacade extends AbstractFacade<Gestionescomerciales> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GestionescomercialesFacade() {
        super(Gestionescomerciales.class);
    }
    
        public List<Gestionescomerciales> mostrarTodasLasGestionesComercialesDeudor(Deudores d) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM Gestionescomerciales WHERE idDeudor = ? order by fechaGestion desc", Gestionescomerciales.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public List<Gestionescomerciales> mostrarTodasLasGestionesComercialesConContacto(Deudores d) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM Gestionescomerciales WHERE idDeudor = ? and contacto in(\"DEUDOR\",\"CODEUDOR\",\"APODERADO\",\"TERCERO\") order by fechaGestion desc", Gestionescomerciales.class);
        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public List<String> encontrarGestion() {
        Query q = getEntityManager().createNativeQuery("SELECT DISTINCT(gestion) FROM `combinacionescomerciales` ORDER by gestion");
//        q.setParameter(1, d.getIdDeudor());
        return q.getResultList();
    }

    public Date traerUltimaFechaContactoTelefonico(Deudores d) {
        try {
            Query q = getEntityManager().createNativeQuery("select fechaGestion from gestionescomerciales where idGestion in (\n"
                    + "SELECT max(idGestion) FROM `gestionescomerciales` WHERE idDeudor = ? and contacto in ('DEUDOR','CODEUDOR','APODERADO'))");
            q.setParameter(1, d.getIdDeudor());
            return (Date) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    public List<String> encontrarResultado(String gestion) {
        Query q = getEntityManager().createNativeQuery("SELECT DISTINCT(resultado) FROM `combinacionescomerciales`  where gestion = ? ORDER by gestion");
        q.setParameter(1, gestion);
        return q.getResultList();
    }

    public List<String> encontrarContacto(String gestion, String resultado) {
        Query q = getEntityManager().createNativeQuery("SELECT DISTINCT(contacto) FROM `combinacionescomerciales` WHERE gestion = ? and resultado = ? ORDER BY contacto");
        q.setParameter(1, gestion);
        q.setParameter(2, resultado);
        return q.getResultList();
    }
    
}
