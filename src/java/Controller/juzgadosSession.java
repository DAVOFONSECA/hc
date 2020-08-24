/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Ciudades;
import Entity.Juzgados;
import Facade.CiudadesFacade;
import Facade.JuzgadosFacade;
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
@Named(value = "juzgadosSession")
@SessionScoped
public class juzgadosSession implements Serializable {
 @EJB
    JuzgadosFacade jF;
    @EJB
    CiudadesFacade cF;
    @Inject
    iniciarSession iS;

    private Juzgados juzgado = new Juzgados();
    private String mensajeModificarJuzgado = "";
    private String mensajeCrearJuzgado = "";

    public juzgadosSession() {
    }

    public void limpiarJuzgados() {
        juzgado = new Juzgados();
        mensajeModificarJuzgado = "";
        mensajeCrearJuzgado = "";
    }

    public List<Juzgados> traerTodosLosJuzgados() {
        return jF.findAll();
    }

    public String guardarModificarJuzgado(Juzgados u) {
        juzgado = u;
        return "Administrativas.Juzgados.Modificar.xhtml?faces-redirect=true";
    }

    public String modificarJuzgado() {

        juzgado.setNombre(juzgado.getNombre().toUpperCase());
        juzgado.setDireccion(juzgado.getDireccion().toUpperCase());
        jF.edit(juzgado);
        iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "MODIFICAR JUZGADO", juzgado.getNombre());
        mensajeModificarJuzgado = "El juzgado se modificó exitosamente.";
        return "";
    }

    public String crearJuzgado() {

        try {
            jF.create(juzgado);
            iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "CREAR JUZGADO", juzgado.getNumero() + juzgado.getCodigoClase() + juzgado.getIdCiudad().getCiudad());
            mensajeCrearJuzgado = "El juzgado ha sido creada exitosamente.";

        } catch (Exception e) {
            mensajeCrearJuzgado = "Ocurrió un error en la ejecución, por favor intente de nuevo.";
        }
        return "";
    }

    public List<Ciudades> traerTodosLasCiudades() {
        return cF.findAll();
    }

    public Juzgados getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(Juzgados juzgado) {
        this.juzgado = juzgado;
    }

    public String getMensajeModificarJuzgado() {
        return mensajeModificarJuzgado;
    }

    public void setMensajeModificarJuzgado(String mensajeModificarJuzgado) {
        this.mensajeModificarJuzgado = mensajeModificarJuzgado;
    }

    public String getMensajeCrearJuzgado() {
        return mensajeCrearJuzgado;
    }

    public void setMensajeCrearJuzgado(String mensajeCrearJuzgado) {
        this.mensajeCrearJuzgado = mensajeCrearJuzgado;
    }    
}
