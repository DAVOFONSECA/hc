/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Acuerdos;
import Entity.Cuotasacuerdos;
import Facade.AcuerdosFacade;
import Facade.CuotasacuerdosFacade;
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
@Named(value = "compromisosSession")
@SessionScoped
public class compromisosSession implements Serializable {

    @EJB
    AcuerdosFacade aF;
    @EJB
    CuotasacuerdosFacade cF;
    @Inject
    obligacionesSession oS;
    @Inject
    iniciarSession iS;
    @Inject
    gestionesComercialesSession gCS;
    @Inject
    deudoresSession dS;

    private Acuerdos compromisos = new Acuerdos();
    private Cuotasacuerdos cuota = new Cuotasacuerdos();
    private String fechaInicial = "";
    private String periodos = "";
    private String valorCuota;
    private String mensajeCompromisos = "";
    private String fechaCuota = "";

    public compromisosSession() {
    }

    public String limpiarCompromisos() {
        fechaInicial = "";
        periodos = "";
        valorCuota = "";
        compromisos = new Acuerdos();
        mensajeCompromisos = "";
        cuota = new Cuotasacuerdos();
        fechaCuota = "";
        return "";

    }

    public String limpiarCuotas() {
        cuota = new Cuotasacuerdos();
        return "";

    }

    public void crearCompromisosDePago() {
        String observaciones = "";
        try {
            if (aF.verificarCompromisosPrevios(compromisos.getIdObligacion()) == 1) {
                mensajeCompromisos = "No es posible crear compromisos nuevos, la obligación tiene compromisos de pago pendientes.";
            } else {
                compromisos.setTipo("COMPROMISOS");
                compromisos.setFechaCreacion(new Date());
                compromisos.setEstado("VIGENTE");
                aF.create(compromisos);
                cuota.setIdAcuerdo(aF.traerUltimoAcuerdo());
                cuota.setEstado("PENDIENTE");
                cuota.setValorCuota(Double.parseDouble(valorCuota));
                for (int i = 0; i < compromisos.getPlazo(); i++) {
                    cuota.setNumeroCuota((i + 1));
                    cuota.setFechaCuota(iS.sumarDiasAFecha(iS.pasarStringADate(fechaInicial), i, periodos));
                    cF.create(cuota);
                }
                observaciones = "COMPROMISOS DE PAGO PARA LA OBLIGACION " + compromisos.getIdObligacion().getNumero() + ". FECHA INICIAL: " + iS.pasarDateAString(iS.pasarStringADate(fechaInicial)) + ", FECHA FINAL:  " + iS.pasarDateAString(iS.sumarDiasAFecha(iS.pasarStringADate(fechaInicial), (compromisos.getPlazo() - 1), periodos)) + ". VALOR DE LAS CUOTAS: " + valorCuota + ". PLAZO:" + compromisos.getPlazo() + " " + periodos + ". CÓDIGO DEL COMPROMISO: "+compromisos.getIdAcuerdo()+".";
                gCS.agregarGestionComercialVarias("TRAMITAR COMPROMISOS", " ", " ", "CREAR COMPROMISOS", " ", observaciones, " ", dS.getDeudor());
                limpiarCompromisos();
            }
        } catch (Exception e) {
            System.out.println("excetion: " + e);
        }
    }

    public List<Acuerdos> traerCompromisosDeUnaObligaciones() {
        try {
            return aF.traerCompromisosDeUnaObligaciones(oS.getObligacion());
        } catch (Exception e) {
            return null;
        }
    }

    public String guardarCompromiso(Acuerdos u) {
        compromisos = u;
        return "";
    }

    public String romperCompromisoYCuotas() {
        try {
            compromisos.setEstado("ROTO");
            aF.edit(compromisos);
            gCS.agregarGestionComercialVarias("TRAMITAR COMPROMISOS", " ", " ", "ROMPER COMPROMISO", " ", "CÓDIGO DEL COMPROMISO ROTO: "+compromisos.getIdAcuerdo()+".", " ", dS.getDeudor());
            limpiarCompromisos();
        } catch (Exception e) {

        }

        return "";
    }

    public Date guardarCuota(Cuotasacuerdos u) {
        cuota = u;
        fechaCuota = iS.pasarDateAStringYYYYMMDD(cuota.getFechaCuota());
        valorCuota = String.valueOf(cuota.getValorCuota());
        fechaInicial = iS.pasarDateAString(cuota.getFechaCuota());

        return cuota.getFechaCuota();
    }

    public String modificarCuota() {
        cuota.setFechaCuota(iS.pasarStringADate(fechaCuota));
        cF.edit(cuota);
        String observaciones = "MODIFICAR CUOTA: " + fechaInicial + " " + valorCuota + "  --> " + iS.pasarDateAString(cuota.getFechaCuota()) + " " + cuota.getValorCuota() + ". ACUERDO OBLIGACION NO. " + cuota.getIdAcuerdo().getIdObligacion().getNumero()+". CÓDIGO DEL COMPROMISO MODIFICADO: "+compromisos.getIdAcuerdo()+".";
        gCS.agregarGestionComercialVarias("TRAMITAR COMPROMISOS", " ", " ", "MODIFICAR CUOTA", " ", observaciones, " ", dS.getDeudor());
        return "";
    }

    public String reportarCuotaPaga(Cuotasacuerdos u) {
        cuota = u;
        fechaInicial = iS.pasarDateAString(cuota.getFechaCuota());
        cuota.setEstado("PAGADA");
        cF.edit(cuota);
        String observaciones = "REPORTAR PAGO DE CUOTA: " + fechaInicial + ". ACUERDO OBLIGACION NO. " + cuota.getIdAcuerdo().getIdObligacion().getNumero()+". CÓDIGO DEL COMPROMISO: "+compromisos.getIdAcuerdo()+".";
        gCS.agregarGestionComercialVarias("TRAMITAR COMPROMISOS", " ", " ", "REPORTAR PAGO CUOTA", " ", observaciones, " ", dS.getDeudor());
        return "";
    }

    public List<Cuotasacuerdos> traerTodosLasCuotasDeUnCompromiso() {

        return aF.traerTodosLasCuotasDeUnCompromiso(compromisos);
    }

    public Acuerdos getCompromisos() {
        return compromisos;
    }

    public void setCompromisos(Acuerdos compromisos) {
        this.compromisos = compromisos;
    }

    public Cuotasacuerdos getCuota() {
        return cuota;
    }

    public void setCuota(Cuotasacuerdos cuota) {
        this.cuota = cuota;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getPeriodos() {
        return periodos;
    }

    public void setPeriodos(String periodos) {
        this.periodos = periodos;
    }

    public String getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(String valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String getMensajeCompromisos() {
        return mensajeCompromisos;
    }

    public void setMensajeCompromisos(String mensajeCompromisos) {
        this.mensajeCompromisos = mensajeCompromisos;
    }

    public String getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(String fechaCuota) {
        this.fechaCuota = fechaCuota;
    }

}
