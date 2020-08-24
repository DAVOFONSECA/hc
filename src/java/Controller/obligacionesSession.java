/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Garantias;
import Entity.Obligaciones;
import Facade.ObligacionesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "obligacionesSession")
@SessionScoped
public class obligacionesSession implements Serializable {

   @EJB
    ObligacionesFacade oF;
    @Inject
    deudoresSession dS;
    @Inject
    compromisosSession cS;
    private Obligaciones obligacion = new Obligaciones();

    public obligacionesSession() {
    }

    public String traerMejorGarantiaDeudor() {
        int contarPersonal = 0, contarFng = 0, contarPrendaria = 0, contarHipotecaria = 0;
        try {
            for (Garantias lista : oF.traerTiposGarantiasDeudor(dS.getDeudor())) {
                if ("FIRMA PERSONAL".equals(lista.getTipo())) {
                    contarPersonal++;
                }
                if ("FNG".equals(lista.getTipo())) {
                    contarFng++;
                }
                if ("PRENDARIA".equals(lista.getTipo())) {
                    contarPrendaria++;
                }
                if ("HIPOTECARIA".equals(lista.getTipo())) {
                    contarHipotecaria++;
                }
            }
            if (contarHipotecaria > 0) {
                return "HIPOTECARIA";
            } else if (contarPrendaria > 0) {
                return "PRENDARIA";
            } else if (contarFng > 0) {
                return "FNG";
            } else if (contarPersonal > 0){
                return "FIRMA PERSONAL";
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }

    }

    public List<Obligaciones> traerObligacionesDeudor() {
        try {
            return oF.traerObligacionesDeudor(dS.getDeudor());
        } catch (Exception e) {
            return null;
        }
    }
    
        public List<Obligaciones> traerObligacionesDeudorSinAcuerdos() {
        try {
            return oF.traerObligacionesDeudorSinAcuerdos(dS.getDeudor());
        } catch (Exception e) {
            return null;
        }
    }

    public String consultarSaldosObligaciones(Obligaciones o) {
        try {
            obligacion = o;
            cS.limpiarCompromisos();
        } catch (Exception e) {
        }
        return "";
    }

    public List<Garantias> traerGarantiasDeLasOligaciones(Obligaciones ob) {
        try {
            return oF.traerGarantiasDeLasOligaciones(ob);
        } catch (Exception e) {
            return null;
        }
    }

    public Obligaciones getObligacion() {
        return obligacion;
    }

    public void setObligacion(Obligaciones obligacion) {
        this.obligacion = obligacion;
    }
}
