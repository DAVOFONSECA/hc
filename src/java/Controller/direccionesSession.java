/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Direcciones;
import Facade.DireccionesFacade;
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
@Named(value = "direccionesSession")
@SessionScoped
public class direccionesSession implements Serializable {

    @EJB
    DireccionesFacade dirF;
    @Inject
    deudoresSession dS;
    @Inject
    gestionesComercialesSession gCS;

    private Direcciones direccion = new Direcciones();

    public direccionesSession() {
    }

    public String limpiarDirecciones() {

        direccion = new Direcciones();
        return "";
    }

    public List<Direcciones> traerTodosLasDireccionesFisicasDeUnDeudor() {
        return dirF.traerTodosLasDireccionesFisicasDeUnDeudor(dS.getDeudor());
    }

    public List<Direcciones> traerTodosLasDireccionesElectronicasDeUnDeudor() {
        return dirF.traerTodosLasDireccionesElectronicasDeUnDeudor(dS.getDeudor());
    }

    public void guardarDireccion(Direcciones dir) {
        direccion = dir;
    }

    public void activarDireccion(Direcciones dir) {
        direccion = dir;
        direccion.setEstado("ACTIVA");
        dirF.edit(direccion);
        gCS.agregarGestionComercialVarias("GESTIONAR DIRECCIONES", " ", "SIN CONTACTO", "ACTIVAR DIRECCION", " ", direccion.getDireccion(), " ", dS.getDeudor());

    }

    public void inactivarDireccion(Direcciones dir) {
        direccion = dir;
        direccion.setEstado("INACTIVA");
        dirF.edit(direccion);
        gCS.agregarGestionComercialVarias("GESTIONAR DIRECCIONES", " ", "SIN CONTACTO", "INACTIVAR DIRECCION", " ", direccion.getDireccion(), " ", dS.getDeudor());
    }

    public String agregarDireccionFisica() {

        try {
            direccion.setTipo("FISICA");
            direccion.setDireccion(direccion.getDireccion().toUpperCase());
            direccion.setBarrio(direccion.getBarrio().toUpperCase());
            direccion.setLocalidad(direccion.getLocalidad().toUpperCase());
            direccion.setCorrespondencia("NO");
            direccion.setNotificacion("NO");
            direccion.setFechaUltimaActualizacion(new Date());
            direccion.setEstado("ACTIVA");
            direccion.setIdDeudor(dS.getDeudor());
            dirF.create(direccion);
            gCS.agregarGestionComercialVarias("GESTIONAR DIRECCIONES", " ", "SIN CONTACTO", "AGREGAR DIRECCION", " ", direccion.getDireccion(), " ", dS.getDeudor());
            direccion = new Direcciones();
        } catch (Exception e) {
        }

        return "";
    }

    public String agregarDireccionElectronica() {
        try {
            direccion.setTipo("EMAIL");
            System.out.println("direccion: " + direccion.getTipo());
            direccion.setDireccion(direccion.getDireccion().toUpperCase());
            System.out.println("direccion: " + direccion.getDireccion());
            direccion.setCorrespondencia("NO");
            direccion.setNotificacion("NO");
            direccion.setFechaUltimaActualizacion(new Date());
            direccion.setEstado("ACTIVA");
            direccion.setIdDeudor(dS.getDeudor());
            dirF.create(direccion);
            gCS.agregarGestionComercialVarias("GESTIONAR DIRECCIONES", " ", "SIN CONTACTO", "AGREGAR DIRECCION", " ", direccion.getDireccion(), " ", dS.getDeudor());
            direccion = new Direcciones();
        } catch (Exception e) {
        }

        return "";
    }

    public String modificar() {
        try {
            direccion.setFechaUltimaActualizacion(new Date());
            direccion.setBarrio(direccion.getBarrio().toUpperCase());
            direccion.setBarrio(direccion.getBarrio().toUpperCase());
            direccion.setLocalidad(direccion.getLocalidad().toUpperCase());
            dirF.edit(direccion);
            gCS.agregarGestionComercialVarias("GESTIONAR DIRECCIONES", " ", "SIN CONTACTO", "MODIFICAR DIRECCION", " ", direccion.getDireccion(), " ", dS.getDeudor());
        } catch (Exception e) {
        }

        return "";
    }

        public String modificarDireccionElectronica() {
        try {
            direccion.setFechaUltimaActualizacion(new Date());
            dirF.edit(direccion);
            gCS.agregarGestionComercialVarias("GESTIONAR DIRECCIONES", " ", "SIN CONTACTO", "MODIFICAR DIRECCION", " ", direccion.getDireccion(), " ", dS.getDeudor());
        } catch (Exception e) {
        }

        return "";
    }
        
    public Direcciones getDireccion() {
        return direccion;
    }

    public void setDireccion(Direcciones direccion) {
        this.direccion = direccion;
    }

}
