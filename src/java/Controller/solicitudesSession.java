/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Actuacionessolicitudes;
import Entity.Deudores;
import Entity.Solicitudes;
import Facade.ActuacionessolicitudesFacade;
import Facade.SolicitudesFacade;
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
@Named(value = "solicitudesSession")
@SessionScoped
public class solicitudesSession implements Serializable {

    @EJB
    SolicitudesFacade sF;
    @EJB
    ActuacionessolicitudesFacade aF;
    @Inject
    deudoresSession dS;
    @Inject
    iniciarSession iS;
    @Inject
    usuariosSession uS;

    private Solicitudes solicitudes = new Solicitudes();
    private Actuacionessolicitudes actuaciones = new Actuacionessolicitudes();
    private String mensaje = "";
    private String fechaCapturada = "";


    public solicitudesSession() {
    }

    public List<Solicitudes> traerTodasLasSolicitudes() {
        return sF.traerTodosLasSolicitudes();
    }

    public List<Solicitudes> traerSolicitudesQueDeboResolver() {
        return sF.traerSolicitudesQueDeboResolver(iS.getUsuarioLogueado());
    }

    public List<Solicitudes> traerSolicitudesQueEscale() {
        return sF.traerSolicitudesQueEscale(iS.getUsuarioLogueado());
    }

    public List<Solicitudes> traerSolicitudesDevueltas() {
        return sF.traerSolicitudesDevueltas(iS.getUsuarioLogueado());
    }

    public String agregarSolicitud(String tipo, String subTipo, String entidad, String observacion, String solicitado, Deudores d) {
        try {
            solicitudes.setFechaSolicitud(new Date());
            if (tipo.equals("COMERCIAL")) {
                solicitudes.setFechaLimite(iS.sumarDiasAFecha(new Date(), 3, "DIAS"));
            } else {
                solicitudes.setFechaLimite(iS.sumarDiasAFecha(new Date(), 7, "DIAS"));
            }
            solicitudes.setEntidadODestinatario(entidad);
            solicitudes.setTipoSolicitud(tipo);
            solicitudes.setSubTipoSolicitud(subTipo);
            solicitudes.setEntidadODestinatario(entidad.toUpperCase());
            solicitudes.setObservaciones(observacion.toUpperCase());
            solicitudes.setEstado("PENDIENTE");
            solicitudes.setIdSolicitante(iS.getUsuarioLogueado());
            solicitudes.setIdSolicitado(uS.traerUsuario(solicitado));
            solicitudes.setIdDeudor(d);
            sF.create(solicitudes);
        } catch (Exception e) {
        }

        return "";
    }

    public String aceptarSolicitudes(Solicitudes s) {
        solicitudes = s;
        actuaciones.setGestion("ACEPTAR SOLICITUD");
        actuaciones.setFechaActuacion(new Date());
        actuaciones.setFechaGestion(new Date()); //fecha efectiva 
        actuaciones.setIdsolicitud(s);
        actuaciones.setObservaciones("SE ACEPTA LA SOLICITUD");
        actuaciones.setIdUsuario(iS.getUsuarioLogueado());
        solicitudes.setIdSolicitado(iS.getUsuarioLogueado());
        aF.create(actuaciones);
        s.setEstado("ACEPTADA");
        sF.edit(s);
        solicitudes = new Solicitudes();
        return "";
    }

    public String guardarSolicitudes(Solicitudes s) {
        try {
            solicitudes = s;
        } catch (Exception e) {
        }
        return "Tareas.Modificar.xhtml?faces-redirect=true";
    }

    public List<Actuacionessolicitudes> traerActuaciones() {
        return aF.traerActaciones(solicitudes);
    }

    public String modificarActuacion() {

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fechaCapturada);
            actuaciones.setFechaActuacion(new Date());
            actuaciones.setFechaGestion(date); //fecha efectiva 
            actuaciones.setIdsolicitud(solicitudes);
            actuaciones.setObservaciones(actuaciones.getObservaciones().toUpperCase());
            actuaciones.setIdUsuario(iS.getUsuarioLogueado());
            aF.create(actuaciones);
            solicitudes.setEstado(encontrarEstadoSolicitud(actuaciones.getGestion()));
            sF.edit(solicitudes);

            actuaciones = new Actuacionessolicitudes();
        } catch (Exception e) {
        }
        return "";
    }

    public String reasignarSolicitud() {

        if (solicitudes.getEstado().equals("RESUELTA") || solicitudes.getEstado().equals("DEVUELTA") || solicitudes.getEstado().equals("DESISTIDA")) {
            mensaje = "No es posible re asignar el usuario";
        } else {
            actuaciones.setFechaActuacion(new Date()); //fecha registro
            actuaciones.setFechaGestion(new Date());
            actuaciones.setGestion("REASIGNAR USUARIO");
            actuaciones.setObservaciones("NUEVO GESTOR: " + solicitudes.getIdSolicitado().getNombreUsuario() + " // " + actuaciones.getObservaciones().toUpperCase());
            actuaciones.setIdsolicitud(solicitudes);
            actuaciones.setIdUsuario(iS.getUsuarioLogueado());
            solicitudes.setEstado("REASIGNADA");
            sF.edit(solicitudes);
            aF.create(actuaciones);
            actuaciones = new Actuacionessolicitudes();
        }

        return "";

    }

    public String encontrarEstadoSolicitud(String ingreso) {
        String dato = "";
        switch (ingreso) {
            case "ACEPTAR SOLICITUD":
                dato = "ACEPTADA";
                break;
            case "RESOLVER SOLICITUD":
                dato = "RESUELTA";
                break;
            case "REASIGNAR SOLICITUD":
                dato = "PENDIENTE";
                break;
            case "DEVOLVER SOLICITUD":
                dato = "DEVUELTA";
                break;
            case "FINALIZAR SOLICITUD":
                dato = "FINALIZADA";
                break;
            case "DESISTIR SOLICITUD":
                dato = "DESISTIDA";
                break;

            default:
                throw new AssertionError();
        }

        return dato;
    }

    public Solicitudes getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Solicitudes solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Actuacionessolicitudes getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(Actuacionessolicitudes actuaciones) {
        this.actuaciones = actuaciones;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaCapturada() {
        return fechaCapturada;
    }

    public void setFechaCapturada(String fechaCapturada) {
        this.fechaCapturada = fechaCapturada;
    }


}
