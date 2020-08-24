/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Deudores;
import Entity.Telefonos;
import Facade.TelefonosFacade;
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
@Named(value = "telefonosSession")
@SessionScoped
public class telefonosSession implements Serializable {

    @EJB
    TelefonosFacade tF;
    @Inject
    deudoresSession dS;
    @Inject
    gestionesComercialesSession gCS;

    private Telefonos telefono = new Telefonos();

    public telefonosSession() {
    }

    public void limpiarTelefonos() {
        telefono = new Telefonos();
    }

    public List<Telefonos> traerTodoslosTefonosDeUnDeudor() {
        return tF.traerTodoslosTefonosDeUnDeudor(dS.getDeudor());
    }

    public List<Telefonos> traerTelefonosActivosDeudor() {
        return tF.traerTelefonosActivosDeudor(dS.getDeudor());
    }

    public void actualizarIntentosTelefónicos(String telefonoDato, String contacto, Deudores d) {

        try {
            int suma = 0;
            if (contacto.equals("APODERADO") || contacto.equals("CODEUDOR") || contacto.equals("DEUDOR")) {
                suma = 1;
            } else {
                suma = 0;
            }
            telefono = tF.traerTelefonos(d, telefonoDato);
            //Intentos 
            if (telefono.getIntentos() == null) {
                telefono.setIntentos(1);
            } else {
                telefono.setIntentos(telefono.getIntentos() + 1);
            }
            //intentos efectivos. 
            if (telefono.getIntentosEfectivos() == null) {
                telefono.setIntentosEfectivos(suma);
            } else {
                telefono.setIntentosEfectivos(telefono.getIntentosEfectivos() + suma);
            }
            tF.edit(telefono);
        } catch (Exception e) {
        }
    }

    public void guardarTelefono(Telefonos t) {
        telefono = t;
    }

    public void modificarTelefono() {
        telefono.setFechaUltimaActualizacion(new Date());
        tF.edit(telefono);
        gCS.agregarGestionComercialVarias("GESTIONAR TELEFONOS", telefono.getTelefono(), "SIN CONTACTO", "MODIFICAR TELEFONO", " ", " ", " ", dS.getDeudor());
    }

    public void agregarTelefono() {
        telefono.setFechaUltimaActualizacion(new Date());
        telefono.setEstado("ACTIVO");
        telefono.setIdDeudor(dS.getDeudor());
        tF.create(telefono);
        gCS.agregarGestionComercialVarias("GESTIONAR TELEFONOS", telefono.getTelefono(), "SIN CONTACTO", "AGREGAR TELEFONO", " ", " ", " ", dS.getDeudor());

    }

    public void dejarMensaje(Telefonos t) {
        telefono = t;
        actualizarIntentosTelefónicos(telefono.getTelefono(), " ", dS.getDeudor());
        gCS.agregarGestionComercialVarias("HACER LLAMADA", telefono.getTelefono(), "BUZÓN", "MENSAJE", "SIN MOTIVO", "MENSAJE BUZÓN", " ", dS.getDeudor());

    }

    public void activarTelefono(Telefonos t) {
        telefono = t;
        telefono.setEstado("ACTIVO");
        tF.edit(telefono);
        gCS.agregarGestionComercialVarias("GESTIONAR TELEFONOS", telefono.getTelefono(), "SIN CONTACTO", "ACTIVAR TELEFONO", " ", " ", " ", dS.getDeudor());

    }

    public void inactivarTelefono(Telefonos t) {
        telefono = t;
        telefono.setEstado("INACTIVO");
        tF.edit(telefono);
        gCS.agregarGestionComercialVarias("GESTIONAR TELEFONOS", telefono.getTelefono(), "SIN CONTACTO", "INACTIVAR TELEFONO", " ", " ", " ", dS.getDeudor());

    }

    public Telefonos getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefonos telefono) {
        this.telefono = telefono;
    }
}
