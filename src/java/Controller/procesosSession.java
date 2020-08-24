/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Deudores;
import Entity.Entidades;
import Entity.Juzgados;
import Entity.JuzgadosProcesos;
import Entity.Procesos;
import Entity.ProcesosDemandados;
import Entity.ProcesosDemandantes;
import Facade.DireccionesFacade;
import Facade.JuzgadosFacade;
import Facade.JuzgadosProcesosFacade;
import Facade.ProcesosDemandadosFacade;
import Facade.ProcesosDemandantesFacade;
import Facade.ProcesosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "procesosSession")
@SessionScoped
public class procesosSession implements Serializable {

    @EJB
    ProcesosFacade pF;
    @EJB
    ProcesosDemandantesFacade pDEF;
    @EJB
    ProcesosDemandadosFacade pDDF;
    @EJB
    DireccionesFacade dirF;
    @EJB
    JuzgadosProcesosFacade jPF;
    @EJB
    JuzgadosFacade jF;
    @Inject
    deudoresSession dS;

    private ArrayList<Entidades> demandantes = new ArrayList();
    private Entidades entidades = new Entidades();
    private ArrayList<Deudores> demandados = new ArrayList();
    private Deudores deudores = new Deudores();
    private Procesos procesos = new Procesos();
    private ProcesosDemandantes procesosDemandantes = new ProcesosDemandantes();
    private ProcesosDemandados procesosDemandados = new ProcesosDemandados();
    private String mensajeErrorCrear = "";
    private Juzgados juzgados = new Juzgados();
    private JuzgadosProcesos juzgadosProcesos = new JuzgadosProcesos();

    public procesosSession() {
    }

    public void borrarPartesDelProceso() {
        demandados.clear();
        entidades = new Entidades();
        demandantes.clear();
        deudores = new Deudores();
        procesos = new Procesos();
    }

    public void limpiarProcesos() {
        procesos = new Procesos();
        procesosDemandantes = new ProcesosDemandantes();
        procesosDemandados = new ProcesosDemandados();
        juzgados = new Juzgados();
        juzgadosProcesos = new JuzgadosProcesos();

    }

    public List<ProcesosDemandados> traerTodos() {
        return pDDF.findAll();
    }

    public String encontrarUnProceso() {
        try {
            procesos = pF.encontrarProceso(procesos);
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public List<JuzgadosProcesos> encontrarJuzgadosDeUnProceso() {
        return jF.encontrarJuzgadosDeUnProceso(procesos);
    }

    public List<ProcesosDemandados> encontrarDemandados() {
        return pF.encontrarDemandados(procesos);
    }

    public List<ProcesosDemandantes> encontrarDemandantes() {
        return pF.encontrarDemandantes(procesos);
    }

    public void eliminarDemandantes() {
        demandantes.clear();
    }

    public void agregarDemandantes() {
        demandantes.add(entidades);
    }

    public void eliminarDemandados() {
        demandados.clear();
    }

    public void agregarDemandados() {
        demandados.add(deudores);
    }

    public String guardarProceso(ProcesosDemandados u) {
        procesos = u.getIdProceso();
        return "Procesos.GestionarUnProceso.xhtml?faces-redirect=true";
    }

    public String guardarEditarProceso(ProcesosDemandados u) {
        procesos = u.getIdProceso();
        return "Procesos.Modificar.xhtml?faces-redirect=true";
    }

    public String agregarProceso() {
        if (demandados.isEmpty() || demandantes.isEmpty()) {
            mensajeErrorCrear = "Ocurrió un error. Por favor adicione las partes del proceso para continuar.";
            return "";
        } else {
            try {
                procesos.setExpedienteCorto("XXXX-XXXX");
                procesos.setPaqueteJuridico("DEMANDA NUEVA");
                procesos.setExpedienteLargo("XXXXXXXXXXXXXXXXXXXXXXX");
                procesos.setUbicacion("AL DESPACHO");
                procesos.setEstado("ACTIVO");
                procesos.setCuantiaProceso("SIN CUANTIA");
                pF.create(procesos);
                agregarProcesoDemandados();
                agregarProcesoDemandantes();
                agregarUnJuzgadoAUnProceso();
                borrarPartesDelProceso();
                mensajeErrorCrear = "";
                eliminarDemandados();
                eliminarDemandantes();
                return "Procesos.Todos.xhtml";
            } catch (Exception e) {
            }
            return "";
        }
    }

    public String agregarProcesoDemandados() {
        try {
            procesos = (pF.utProceso());
            procesosDemandados.setIdProceso(procesos);
            Iterator<Deudores> it = demandados.iterator();
            while (it.hasNext()) {
                procesosDemandados.setIdDeudor(it.next());
                pDDF.create(procesosDemandados);
            }
        } catch (Exception e) {
            mensajeErrorCrear = "Ocurrió un error al intentar crear el proceso, por favor verifique e intente de nuevo.";
        }
        demandados.clear();
        return "";
    }

    public String agregarProcesoDemandantes() {
        try {
            procesosDemandantes.setIdProceso(procesos = (pF.utProceso()));
            Iterator<Entidades> it = demandantes.iterator();
            while (it.hasNext()) {
                procesosDemandantes.setIdEntidad(it.next());
                pDEF.create(procesosDemandantes);
            }
        } catch (Exception e) {
            mensajeErrorCrear = "Ocurrió un error al intentar crear el proceso, por favor verifique e intente de nuevo.";
        }
        demandantes.clear();

        return "";
    }

    public String agregarDemandantesAProceso() {
        procesosDemandantes.setIdEntidad(entidades);
        procesosDemandantes.setIdProceso(procesos);
        pDEF.create(procesosDemandantes);
        return "";
    }

    public String agregarDemandadosAProceso() {
        procesosDemandados.setIdDeudor(deudores);
        procesosDemandados.setIdProceso(procesos);
        pDDF.create(procesosDemandados);
        return "";
    }

    public String agregarUnJuzgadoAUnProceso() {
        juzgadosProcesos.setFechaIngreso(new Date());
        juzgadosProcesos.setIdJuzgado(juzgados);
        juzgadosProcesos.setIdProceso(pF.utProceso());
        juzgadosProcesos.setRelacion("JUZGADO ORIGEN");
        juzgadosProcesos.setObservacion(" ");
        jPF.create(juzgadosProcesos);
        return "";
    }

    public String quitarDemandadosAProceso(ProcesosDemandados p) {
        pDDF.remove(p);
        return "";
    }

    public String quitarDemandantesAProceso(ProcesosDemandantes p) {
        pDEF.remove(p);
        return "";
    }

    public String modificarProceso() {
        pF.edit(procesos);
        return "";
    }

    public String gestionarUnDeudor(Deudores u) {
        dS.setDeudor(u);
        return "Deudores.GestionarUnDeudor.xhtml?faces-redirect=true";
    }

    public ArrayList<Entidades> getDemandantes() {
        return demandantes;
    }

    public void setDemandantes(ArrayList<Entidades> demandantes) {
        this.demandantes = demandantes;
    }

    public Entidades getEntidades() {
        return entidades;
    }

    public void setEntidades(Entidades entidades) {
        this.entidades = entidades;
    }

    public ArrayList<Deudores> getDemandados() {
        return demandados;
    }

    public void setDemandados(ArrayList<Deudores> demandados) {
        this.demandados = demandados;
    }

    public Deudores getDeudores() {
        return deudores;
    }

    public void setDeudores(Deudores deudores) {
        this.deudores = deudores;
    }

    public Procesos getProcesos() {
        return procesos;
    }

    public void setProcesos(Procesos procesos) {
        this.procesos = procesos;
    }

    public ProcesosDemandantes getProcesosDemandantes() {
        return procesosDemandantes;
    }

    public void setProcesosDemandantes(ProcesosDemandantes procesosDemandantes) {
        this.procesosDemandantes = procesosDemandantes;
    }

    public ProcesosDemandados getProcesosDemandados() {
        return procesosDemandados;
    }

    public void setProcesosDemandados(ProcesosDemandados procesosDemandados) {
        this.procesosDemandados = procesosDemandados;
    }

    public String getMensajeErrorCrear() {
        return mensajeErrorCrear;
    }

    public void setMensajeErrorCrear(String mensajeErrorCrear) {
        this.mensajeErrorCrear = mensajeErrorCrear;
    }

    public Juzgados getJuzgados() {
        return juzgados;
    }

    public void setJuzgados(Juzgados juzgados) {
        this.juzgados = juzgados;
    }

    public JuzgadosProcesos getJuzgadosProcesos() {
        return juzgadosProcesos;
    }

    public void setJuzgadosProcesos(JuzgadosProcesos juzgadosProcesos) {
        this.juzgadosProcesos = juzgadosProcesos;
    }

}
