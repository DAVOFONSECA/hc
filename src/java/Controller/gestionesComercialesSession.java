/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Combinacionescomerciales;
import Entity.Deudores;
import Entity.Gestionescomerciales;
import Facade.CombinacionescomercialesFacade;
import Facade.GestionescomercialesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "gestionesComercialesSession")
@SessionScoped
public class gestionesComercialesSession implements Serializable {

    @EJB
    GestionescomercialesFacade gCF;
    @EJB
    CombinacionescomercialesFacade cF;
    @Inject
    deudoresSession dS;
    @Inject
    usuariosSession uS;
    @Inject
    iniciarSession iS;
    @Inject
    telefonosSession tF;
    @Inject
    solicitudesSession sS;

    private Gestionescomerciales gc = new Gestionescomerciales();
    private Combinacionescomerciales cc = new Combinacionescomerciales();
    private Deudores deudor = new Deudores();
    private String todasLasGestiones = "NO";

    public gestionesComercialesSession() {
    }

    public void limpiarGestionComercial() {
        todasLasGestiones = "NO";
        gc = new Gestionescomerciales();
    }

    public String traerUltimaFechaContactoTelefonico() {
        String ultimaFecha = "";
        try {
            ultimaFecha = iS.pasarDateAString(gCF.traerUltimaFechaContactoTelefonico(dS.getDeudor()));
        } catch (Exception e) {
            ultimaFecha = "";
        }
        return ultimaFecha;
    }

    public List<Gestionescomerciales> mostrarTodasLasGestionesComercialesDeudor() {
        try {
            if (todasLasGestiones.equals("SI")) {
                return gCF.mostrarTodasLasGestionesComercialesDeudor(dS.getDeudor());
            } else {
                return gCF.mostrarTodasLasGestionesComercialesConContacto(dS.getDeudor());
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void cambiarBoton() {
        if (todasLasGestiones.equals("SI")) {
            todasLasGestiones = "NO";
        } else {
            todasLasGestiones = "SI";
        }
    }

    public List<String> traerContacto() {
        if ("TRAMITAR SOLICITUD".equals(gc.getGestion())) {
            return uS.traerNombreDeUsuariosActivos();
        } else {
            return gCF.encontrarContacto(gc.getGestion(), gc.getResultado());
        }
    }

    public List<String> traerGestion() {
        return gCF.encontrarGestion();
    }

    public List<String> traerResultado() {
        return gCF.encontrarResultado(gc.getGestion());

    }

    public String agregarGestionComercial() {
        try {
            gc.setFechaGestion(new Date());
            gc.setObservacion(gc.getObservacion().toUpperCase());
            gc.setAdjunto(" ");
            gc.setIdDeudor(dS.getDeudor());
            gc.setIdUsuario(iS.getUsuarioLogueado());
            gCF.create(gc);
            if (gc.getGestion().equals("TRAMITAR SOLICITUD")) {
                sS.agregarSolicitud("COMERCIAL", gc.getResultado(), "SIN ENTIDAD", gc.getObservacion(), gc.getContacto(), dS.getDeudor());
            } else if (gc.getGestion().equals("HACER LLAMADA")) {
                tF.actualizarIntentosTelefónicos(gc.getDato(), gc.getContacto(), dS.getDeudor());
            }
            gc = new Gestionescomerciales();
        } catch (Exception e) {
        }
        return "";
    }

    public String agregarGestionComercialVarias(String gestion, String dato, String contacto, String resultado, String causaMora, String Observacion, String adjunto, Deudores d) {
        try {
            gc.setFechaGestion(new Date());
            gc.setGestion(gestion);
            gc.setDato(dato);
            gc.setContacto(contacto);
            gc.setResultado(resultado);
            gc.setCausaMora(causaMora);
            gc.setObservacion(Observacion.toUpperCase());
            gc.setAdjunto(adjunto);
            gc.setIdDeudor(d);
            gc.setIdUsuario(iS.getUsuarioLogueado());
            gCF.create(gc);
            gc = new Gestionescomerciales();
        } catch (Exception e) {
        }
        return "";
    }

    public Gestionescomerciales getGc() {
        return gc;
    }

    public void setGc(Gestionescomerciales gc) {
        this.gc = gc;
    }

    public Combinacionescomerciales getCc() {
        return cc;
    }

    public void setCc(Combinacionescomerciales cc) {
        this.cc = cc;
    }

    public Deudores getDeudor() {
        return deudor;
    }

    public void setDeudor(Deudores deudor) {
        this.deudor = deudor;
    }

    public String getTodasLasGestiones() {
        return todasLasGestiones;
    }

    public void setTodasLasGestiones(String todasLasGestiones) {
        this.todasLasGestiones = todasLasGestiones;
    }
}
