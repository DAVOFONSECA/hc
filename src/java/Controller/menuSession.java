/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Facade.SolicitudesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "menuSession")
@SessionScoped
public class menuSession implements Serializable {

    @EJB
    SolicitudesFacade sF;
    @Inject
    cartasVisitasSession cVS;
    @Inject
    iniciarSession iS;
    @Inject
    solicitudesSession sS;



    public menuSession() {

    }

    public String irATodosLosDeudoresDesdeUsuarios() {
        return "Administrativas.Deudores.Todos.xhtml?faces-redirect=true";
    }

    public String irATodasLasEntidades() {
        return "Administrativas.Entidades.Todos.xhtml?faces-redirect=true";
    }

    public String irATodosLosJuzgados() {
        return "Administrativas.Juzgados.Todos.xhtml?faces-redirect=true";
    }

    public String irATodosLosUsuarios() {
        return "Administrativas.Usuarios.Todos.xhtml?faces-redirect=true";
    }

    public String irATodosLosDeudores() {
        return "Deudores.Todos.xhtml?faces-redirect=true";
    }

    public String irAGestionarUnDeudor() {
        cVS.setMensaje("");
        cVS.setAcv(null);
        cVS.setCv(null);
        return "Deudores.GestionarUnDeudor.xhtml?faces-redirect=true";
    }

    public String irATareasQueDeboResolver() {
        return "Tareas.DeboResolver.xhtml?faces-redirect=true";
    }

    public String irATareasQueEscale() {
        return "Tareas.QueEscale.xhtml?faces-redirect=true";
    }

    public String irATareasDevueltas() {



        return "Tareas.Devueltas.xhtml?faces-redirect=true";
    }

    public String irATodasLasTareas() {
        return "Tareas.Todas.xhtml?faces-redirect=true";
    }

    public String irATodasLosProcesos() {
        return "Procesos.Todos.xhtml?faces-redirect=true";
    }

      public String irAGestionarUnProceso() {
        return "Procesos.GestionarUnProceso.xhtml?faces-redirect=true";
    }
    public String irACrearProceso() {
        return "Procesos.Crear.xhtml?faces-redirect=true";
    }

}
