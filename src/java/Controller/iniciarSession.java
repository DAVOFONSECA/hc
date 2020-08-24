/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Logdeacciones;
import Entity.Usuarios;
import Facade.LogdeaccionesFacade;
import Facade.UsuariosFacade;
import Utilities.Mailer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author Usuario
 */
@Named(value = "iniciarSession")
@SessionScoped
public class iniciarSession implements Serializable {
@EJB
    UsuariosFacade uF;
    @EJB
    LogdeaccionesFacade lF;

    private Usuarios usuarioLogueado = new Usuarios();
    private Usuarios usuarioDigitado = new Usuarios();
    private Logdeacciones logdeacciones = new Logdeacciones();
    private String mensajeIniciarSesion = "";
    private String mensajeCambiarContrasena = "";
    private String mensajeRecodarContrasena = "";
    private String nuevaContrasena = "";
    private String confirmeContrasena = "";
    int intentos = 0;

    public iniciarSession() {
    }

    public String cerrarSesion() {
        usuarioLogueado = new Usuarios();
        usuarioDigitado = new Usuarios();
        return "";
    }

    public String iniciarSesion() {
        try {
            usuarioLogueado = uF.traerUsuarioBD(usuarioDigitado);
            if ("BLOQUEADO".equals(usuarioLogueado.getEstado())) {
                mensajeIniciarSesion = "El usuario se encuentra bloqueado, consulte con su administrador.";
                usuarioLogueado = null;
                return "";
            } else {
                if (usuarioLogueado.getContrasena().equals(usuarioDigitado.getContrasena())) {
                    if (contarDiasContrasena() == -1) {
                        //se direcciona a la página de cambiar contraseña
                        mensajeCambiarContrasena = "Debe cambiar la contraseña";
                        return "CambiarContrasena.xhtml?faces-redirect=true";
                    } else {
                        mensajeIniciarSesion = "";
                        intentos = 0;
                        registrarLogDeAcciones(usuarioLogueado, "INICIAR SESIÓN", "");
                        usuarioDigitado = new Usuarios();
                        return "Paginas/0.Entrada.xhtml?faces-redirect=true";
                    }
                } else {
                    mensajeIniciarSesion = "La contraseña no coincide, intente nuevamente.";
                    intentos++;
                    if (intentos > 3) {
                        usuarioLogueado.setEstado("BLOQUEADO");
                        uF.edit(usuarioLogueado);
                        registrarLogDeAcciones(usuarioLogueado, "USUARIO BLOQUEADO", "SE BLOQUEA EL USUARIO " + usuarioLogueado.getNombreUsuario() + " POR INTENTOS ERRADOS");
                        mensajeIniciarSesion = "El usuario ha sido bloqueado, contáctese con el administrador";
                    }
                    return "";
                }
            }
        } catch (Exception e) {
            mensajeIniciarSesion = "El usuario ingresado no existe. Inténte de nuevo";
            return "";
        }

    }

    public int contarDiasContrasena() {
        try {
            Date fechaVencimiento = uF.utFechaCambioContrasena(usuarioLogueado).getFecha();
            Date hoy = new Date();
            if (fechaVencimiento == null) {
                fechaVencimiento = new Date();
                fechaVencimiento = sumarDiasAFecha(fechaVencimiento, -45, "DIAS");
            } else {
                fechaVencimiento = sumarDiasAFecha(fechaVencimiento, 30, "DIAS");
            }
            int registro = fechaVencimiento.compareTo(hoy);
            return fechaVencimiento.compareTo(hoy);

        } catch (Exception e) {
            return -1;
        }
    }

    public String cambiarContrasena() {
        try {
            if (nuevaContrasena.equals(usuarioLogueado.getContrasena())) {
                mensajeCambiarContrasena = "La nueva contraseña no puede ser igual a la anterior. Intente con otra contraseña.";
                return "";
            } else if (nuevaContrasena.equals(confirmeContrasena)) {
                usuarioLogueado.setContrasena(nuevaContrasena);
                uF.edit(usuarioLogueado);
                registrarLogDeAcciones(usuarioLogueado, "CAMBIAR CONTRASEÑA", "");
                mensajeCambiarContrasena = "";
                mensajeIniciarSesion = "Contraseña modificada exitosamente.";
                return "index.xhtml?faces-redirect=true";
            } else {
                mensajeCambiarContrasena = "Las contraseñas ingresadas no coinciden. Intente de nuevo";
                return "";
            }
        } catch (Exception e) {
            return "";
        }

    }

    public String direccionarRecordarContraseña() {
        usuarioLogueado = new Usuarios();
        return "RecordarContrasena.xhtml?faces-redirect=true";
    }

    public String recordarCredenciales() {
        try {
            usuarioLogueado = uF.traerUsuarioBD(usuarioDigitado);

            Mailer.recordarContrasena(usuarioLogueado.getCorreoElectronico(), usuarioLogueado.getContrasena());
            mensajeIniciarSesion = "Las credenciales fueron enviadas al correo " + usuarioLogueado.getCorreoElectronico().toLowerCase();
            registrarLogDeAcciones(usuarioLogueado, "RECORDAR CONTRASEÑA", "USUARIO SOLICITA RECORDAR CONTRASEÑA");
            usuarioLogueado = new Usuarios();
            usuarioDigitado = new Usuarios();
            mensajeRecodarContrasena = "";
            return "index.xhtml?faces-redirect=true";

        } catch (Exception e) {
            mensajeRecodarContrasena = "El usuario ingresado no existe, verifique e intente de nuevo";
            return "";
        }
    }

    public void registrarLogDeAcciones(Usuarios u, String tipo, String observaciones) {

        logdeacciones.setFecha(new Date());
        logdeacciones.setIdUsuario(u);
        logdeacciones.setTipo(tipo);
        logdeacciones.setObservaciones(observaciones);
        lF.create(logdeacciones);
        logdeacciones = new Logdeacciones();

    }

    public Date sumarDiasAFecha(Date fecha, int dias, String tipo) {
        String tipoCalculo = "";
        if (dias == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        switch (tipo) {
            case "DIAS":
                calendar.add(Calendar.DAY_OF_YEAR, dias);
                break;
            case "MESES":
                calendar.add(Calendar.MONTH, dias);
                break;
            case "AÑOS":
                calendar.add(Calendar.YEAR, dias);
                break;
            default:
                throw new AssertionError();
        }

        return calendar.getTime();
    }

    public String pasarDateAString(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaComoCadena = sdf.format(d);
        return fechaComoCadena;
    }

    public String pasarDateAStringYYYYMMDD(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String fechaComoCadena = sdf.format(d);
        return fechaComoCadena;
    }

    public Date pasarStringADate(String d) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = d;
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        return fecha;
    }

    public Usuarios getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuarios usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public Usuarios getUsuarioDigitado() {
        return usuarioDigitado;
    }

    public void setUsuarioDigitado(Usuarios usuarioDigitado) {
        this.usuarioDigitado = usuarioDigitado;
    }

    public Logdeacciones getLogdeacciones() {
        return logdeacciones;
    }

    public void setLogdeacciones(Logdeacciones logdeacciones) {
        this.logdeacciones = logdeacciones;
    }

    public String getMensajeIniciarSesion() {
        return mensajeIniciarSesion;
    }

    public void setMensajeIniciarSesion(String mensajeIniciarSesion) {
        this.mensajeIniciarSesion = mensajeIniciarSesion;
    }

    public String getMensajeCambiarContrasena() {
        return mensajeCambiarContrasena;
    }

    public void setMensajeCambiarContrasena(String mensajeCambiarContrasena) {
        this.mensajeCambiarContrasena = mensajeCambiarContrasena;
    }

    public String getMensajeRecodarContrasena() {
        return mensajeRecodarContrasena;
    }

    public void setMensajeRecodarContrasena(String mensajeRecodarContrasena) {
        this.mensajeRecodarContrasena = mensajeRecodarContrasena;
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }

    public String getConfirmeContrasena() {
        return confirmeContrasena;
    }

    public void setConfirmeContrasena(String confirmeContrasena) {
        this.confirmeContrasena = confirmeContrasena;
    }
}
