/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Deudores;
import Entity.EntidadesDeudores;
import Facade.DeudoresFacade;
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
@Named(value = "deudoresSession")
@SessionScoped
public class deudoresSession implements Serializable {

    @EJB
    DeudoresFacade dF;
    @Inject
    iniciarSession iS;

    private Deudores deudor = new Deudores();
    private String mensajeModificarDeudor = "";
    private String mensajeCrearDeudor = "";
    private String mensajeAsociarObligaciones = "";
    private String fechaIngreso = "";
    private String tipoNumeroIdentificacion = "";
    private EntidadesDeudores entidadesDeudor = new EntidadesDeudores();

    public deudoresSession() {
    }

    public void limpiarDeudores() {
        deudor = new Deudores();
        entidadesDeudor = new EntidadesDeudores();
        mensajeModificarDeudor = "";
        mensajeCrearDeudor = "";
        fechaIngreso = "";
    }

    public List<EntidadesDeudores> traerTodosLosDeudoresEntidades() {
        return dF.traerEntidadesDeudores();
    }

    public List<Deudores> traerTodosLosDeudores() {
        return dF.findAll();
    }

    public String guardarConsultarDeudor(EntidadesDeudores u) {
        deudor = u.getIdDeudor();
        tipoNumeroIdentificacion = deudor.getTipoIdentificacion() + deudor.getIdentificacion() + "";
        return "Deudores.GestionarUnDeudor.xhtml?faces-redirect=true";
    }

    public String guardarModificarDeudor(EntidadesDeudores u) {
        deudor = u.getIdDeudor();
        fechaIngreso = iS.pasarDateAString(deudor.getFechaIngreso());
        return "Administrativas.Deudores.Modificar.xhtml?faces-redirect=true";
    }

    public String modificarDeudor() {
        deudor.setPrimerNombre(deudor.getPrimerNombre().toUpperCase());
        deudor.setSegundoNombre(deudor.getSegundoNombre().toUpperCase());
        deudor.setPrimerApellido(deudor.getPrimerApellido().toUpperCase());
        deudor.setSegundoApellido(deudor.getSegundoApellido().toUpperCase());
        deudor.setFechaIngreso(iS.pasarStringADate(fechaIngreso));
        dF.edit(deudor);
        iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "MODIFICAR DEUDOR", deudor.getPrimerNombre() + " " + deudor.getSegundoNombre() + " " + deudor.getPrimerApellido() + " " + deudor.getSegundoApellido());
        mensajeModificarDeudor = "El deudor se modificó exitosamente.";
        return "";
    }

    public String encontrarUnDeudor() {
        int caracteres = 0;
        String tipo = "";
        int numero = 0;

        try {
            caracteres = tipoNumeroIdentificacion.length();
            tipo = tipoNumeroIdentificacion.substring(0, 1);
            numero = Integer.parseInt(tipoNumeroIdentificacion.substring(1, caracteres));
            deudor = dF.encontrarDeudor(tipo, numero);
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public Deudores getDeudor() {
        return deudor;
    }

    public void setDeudor(Deudores deudor) {
        this.deudor = deudor;
    }

    public String getMensajeModificarDeudor() {
        return mensajeModificarDeudor;
    }

    public void setMensajeModificarDeudor(String mensajeModificarDeudor) {
        this.mensajeModificarDeudor = mensajeModificarDeudor;
    }

    public String getMensajeCrearDeudor() {
        return mensajeCrearDeudor;
    }

    public void setMensajeCrearDeudor(String mensajeCrearDeudor) {
        this.mensajeCrearDeudor = mensajeCrearDeudor;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMensajeAsociarObligaciones() {
        return mensajeAsociarObligaciones;
    }

    public void setMensajeAsociarObligaciones(String mensajeAsociarObligaciones) {
        this.mensajeAsociarObligaciones = mensajeAsociarObligaciones;
    }

    public String getTipoNumeroIdentificacion() {
        return tipoNumeroIdentificacion;
    }

    public void setTipoNumeroIdentificacion(String tipoNumeroIdentificacion) {
        this.tipoNumeroIdentificacion = tipoNumeroIdentificacion;
    }

    public EntidadesDeudores getEntidadesDeudor() {
        return entidadesDeudor;
    }

    public void setEntidadesDeudor(EntidadesDeudores entidadesDeudor) {
        this.entidadesDeudor = entidadesDeudor;
    }

}
