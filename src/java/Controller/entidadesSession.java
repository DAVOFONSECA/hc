/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Entidades;
import Facade.EntidadesFacade;
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
@Named(value = "entidadesSession")
@SessionScoped
public class entidadesSession implements Serializable {

   @EJB
    EntidadesFacade eF;
    @Inject
    iniciarSession iS;

    private Entidades entidad = new Entidades();
    private String mensajeModificarEntidad = "";
    private String mensajeCrearEntidad = "";

    public entidadesSession() {
    }

    public void limpiarEntidad() {
        entidad = new Entidades();
        mensajeModificarEntidad = "";
        mensajeCrearEntidad = "";
    }

    public List<Entidades> traerTodasLasEntidades() {
        return eF.findAll();
    }

    public String guardarModificarEntidad(Entidades u) {
        entidad = u;
        return "Administrativas.Entidades.Modificar.xhtml?faces-redirect=true";
    }

    public String modificarEntidad() {
        entidad.setNombre(entidad.getNombre().toUpperCase());
        eF.edit(entidad);
        iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "MODIFICAR ENTIDAD", entidad.getNombre());
        mensajeModificarEntidad = "La entidad se modificó exitosamente.";
        return "";
    }

    public String crearEntidad() {
        try {
            entidad.setNombre(entidad.getNombre().toUpperCase());
            eF.create(entidad);
            iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "CREAR ENTIDAD", entidad.getNombre());
            mensajeCrearEntidad = "La entidad ha sido creada exitosamente.";
        } catch (Exception e) {
            mensajeCrearEntidad = "Ocurrió un error en la ejecución, por favor intente de nuevo.";
        }
        return "";
    }

    public Entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidades entidad) {
        this.entidad = entidad;
    }

    public String getMensajeModificarEntidad() {
        return mensajeModificarEntidad;
    }

    public void setMensajeModificarEntidad(String mensajeModificarEntidad) {
        this.mensajeModificarEntidad = mensajeModificarEntidad;
    }

    public String getMensajeCrearEntidad() {
        return mensajeCrearEntidad;
    }

    public void setMensajeCrearEntidad(String mensajeCrearEntidad) {
        this.mensajeCrearEntidad = mensajeCrearEntidad;
    }


    
}
