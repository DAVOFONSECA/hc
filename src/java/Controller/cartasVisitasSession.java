/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DocumentosComerciales.CartasVisitas;
import Entity.Actuacionescartasvisitas;
import Entity.Cartasvisitas;
import Entity.Direcciones;
import Entity.Usuarios;
import Facade.ActuacionescartasvisitasFacade;
import Facade.CartasvisitasFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "cartasVisitasSession")
@SessionScoped
public class cartasVisitasSession implements Serializable {

    @EJB
    CartasvisitasFacade cVF;
    @EJB
    ActuacionescartasvisitasFacade aCVF;
    @Inject
    iniciarSession iS;
    @Inject
    gestionesComercialesSession gCS;
    @Inject
    CartasVisitas cC;
    @Inject
    solicitudesSession sS;

    private Cartasvisitas cv = new Cartasvisitas();
    private Actuacionescartasvisitas acv = new Actuacionescartasvisitas();
    private Direcciones direcciones = new Direcciones();
    private String fechaCapturadaString = "";
    private String mensaje = "";
    private Usuarios ecargadoCartasVisitas = new Usuarios();

    public cartasVisitasSession() {
    }

    public void limpiarCartasVisitas() {
        cv = new Cartasvisitas();
    }

    public String agregarCartasVisitas() {
        try {
            cv.setGuia(null);
            cv.setEstado("CREADO");
            cv.setIdDireccion(direcciones);
            cVF.create(cv);

            agregarPrimerActuacionCartasVisitas();
            cC.crearDocumento(cv.getTipo());
            gCS.getGc().setDato(" ");
            gCS.getGc().setContacto(" ");
            gCS.getGc().setGestion("ENVIAR CARTA/VISITA");
            gCS.getGc().setResultado(cv.getTipo() + " GENERADA");
            gCS.getGc().setCausaMora(" ");
            gCS.getGc().setObservacion("GENERA DOCUMENTOS: " + direcciones.getDireccion());
            gCS.agregarGestionComercial();
            mensaje = "";
            return "";
        } catch (Exception e) {
            cv = new Cartasvisitas();
            return "";
        }
    }

    public String modificarCartasVisitas() {
        String observacionGC = "";
        try {
            cVF.edit(cv);
            if (cv.getGuia() == null) {
                observacionGC = "COURRIER: " + cv.getCourrier();
            } else {
                observacionGC = "GUIA: " + cv.getGuia() + " COURRIER: " + cv.getCourrier();
            }
            gCS.agregarGestionComercialVarias("GESTIONAR DOCUMENTOS", cv.getIdDireccion().getDireccion(), "SIN CONTACTO", "MODIFICAR CARTA/VISITA", "", observacionGC, "", cv.getIdDireccion().getIdDeudor());
            limpiarCartasVisitas();
            return "";
        } catch (Exception e) {
            cv = new Cartasvisitas();
            return "";
        }
    }

    public String agregarPrimerActuacionCartasVisitas() {
        try {
            acv.setFechaGestion(new Date());
            acv.setFechaActuacion(new Date());
            acv.setIdCartasVisitas(cVF.traerUltimaCartaVisita());
            acv.setGestion("GENERAR DOCUMENTO");
            acv.setResultado("DOCUMENTO GENERADO");
            acv.setObservacion(cv.getTipo() + " COURRIER: " + cv.getCourrier() + ". GENERADO");
            acv.setIdUsuario(iS.getUsuarioLogueado());
            aCVF.create(acv);
            acv = new Actuacionescartasvisitas();
            return "";
        } catch (Exception e) {
            acv = new Actuacionescartasvisitas();
            return "";
        }
    }

    public void agregarActuacionCartasVisitas() {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaCapturadaString);
            acv.setFechaActuacion(date);
            acv.setFechaGestion(new Date());
            acv.setIdUsuario(iS.getUsuarioLogueado());
            acv.setIdCartasVisitas(cv);
            aCVF.create(acv);
            cv.setEstado(actualizarEstadoDocumento(acv.getResultado()));
            cVF.edit(cv);
            gCS.agregarGestionComercialVarias("GESTIONAR DOCUMENTOS", cv.getIdDireccion().getDireccion(), "SIN CONTACTO", "MODIFICAR CARTA/VISITA", "", acv.getObservacion().toUpperCase(), "", cv.getIdDireccion().getIdDeudor());
            cv = new Cartasvisitas();
            acv = new Actuacionescartasvisitas();
            mensaje = "";

        } catch (Exception e) {
            mensaje = "Debe escoger un documento para gestionar";
        }
    }

    public String actualizarEstadoDocumento(String resultado) {
        String resultadoCV = "";
        try {
            if (resultado.equals("ENTREGADO A COURRIER")) {
                resultadoCV = "ENTREGADO A COURRIER";
            } else if (resultado.equals("DESISTIDO")) {
                resultadoCV = "DESISTIDO";
            } else if (resultado.equals("SI RESIDE / SI TRABAJA")) {
                resultadoCV = "ENTREGADO";
            } else {
                resultadoCV = "NO ENTREGADO";
            }
            return resultadoCV;
        } catch (Exception e) {
            return "";
        }
    }

    public List<Cartasvisitas> traerCartasVisitasDireccion() {
        return cVF.traerCartasVisitasDireccion(direcciones);
    }

    public String guardarCartasVisitas(Cartasvisitas t) {
        cv = t;
        System.out.println("carta visita tomada: " + cv.getTipo());
        mensaje = "";
        return "";
    }

    public String guardarDireccionFisicaParaGestionar(Direcciones dir) {
        direcciones = dir;
        return "Deudores.GestionarUnaDireccionFisica.xhtml?faces-redirect=true";
    }

    public List<Actuacionescartasvisitas> traerActuacionesCartasVisitasDireccion() {
        return cVF.traerCartasVisitasDireccion(cv);
    }

    public Cartasvisitas getCv() {
        return cv;
    }

    public void setCv(Cartasvisitas cv) {
        this.cv = cv;
    }

    public Actuacionescartasvisitas getAcv() {
        return acv;
    }

    public void setAcv(Actuacionescartasvisitas acv) {
        this.acv = acv;
    }

    public Direcciones getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Direcciones direcciones) {
        this.direcciones = direcciones;
    }

    public String getFechaCapturadaString() {
        return fechaCapturadaString;
    }

    public void setFechaCapturadaString(String fechaCapturadaString) {
        this.fechaCapturadaString = fechaCapturadaString;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuarios getEcargadoCartasVisitas() {
        return ecargadoCartasVisitas;
    }

    public void setEcargadoCartasVisitas(Usuarios ecargadoCartasVisitas) {
        this.ecargadoCartasVisitas = ecargadoCartasVisitas;
    }

}
