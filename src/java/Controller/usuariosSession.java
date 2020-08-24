/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Usuarios;
import Facade.UsuariosFacade;
import Utilities.Mailer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Usuario
 */
@Named(value = "usuariosSession")
@SessionScoped
public class usuariosSession implements Serializable {

    @EJB
    UsuariosFacade uF;
    @Inject
    iniciarSession iS;

    private String mensajeModificarUsuario = "";
    private String mensajeCrearUsuario = "";

    private Usuarios usuario = new Usuarios();

    public usuariosSession() {
    }

    public void limpiarUsuario() {
        usuario = new Usuarios();
        mensajeModificarUsuario = "";
        mensajeCrearUsuario = "";
    }

    public List<Usuarios> traerTodosLosUsuarios() {
        return uF.findAll();
    }

    public String guardarModificarUsuario(Usuarios u) {
        usuario = u;
        return "Administrativas.Usuarios.Modificar.xhtml?faces-redirect=true";
    }

    public String modificarUsuario() {
        usuario.setPrimerNombre(usuario.getPrimerNombre().toUpperCase());
        usuario.setSegundoNombre(usuario.getSegundoNombre().toUpperCase());
        usuario.setPrimerApellido(usuario.getPrimerApellido().toUpperCase());
        usuario.setSegundoApellido(usuario.getSegundoApellido().toUpperCase());
        usuario.setCorreoElectronico(usuario.getCorreoElectronico().toUpperCase());
        uF.edit(usuario);
        iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "MODIFICAR USUARIO", usuario.getNombreUsuario());
        return "";
    }

    public String desbloquearUsuario() {
        usuario.setEstado("ACTIVO");
        iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "DESBLOQUEAR USUARIO", usuario.getNombreUsuario());
        uF.edit(usuario);
        mensajeModificarUsuario = "El usuario ha sido modificado exitosamente.";
        return "";
    }

    public String bloquearUsuario() {
        usuario.setEstado("BLOQUEADO");
        iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "BLOQUEAR USUARIO", usuario.getNombreUsuario());
        uF.edit(usuario);
        mensajeModificarUsuario = "El usuario ha sido modificado exitosamente.";
        return "";
    }

    public String crearUsuario() {
        try {
            usuario.setPrimerNombre(usuario.getPrimerNombre().toUpperCase());
            usuario.setSegundoNombre(usuario.getSegundoNombre().toUpperCase());
            usuario.setPrimerApellido(usuario.getPrimerApellido().toUpperCase());
            usuario.setSegundoApellido(usuario.getSegundoApellido().toUpperCase());
            usuario.setCorreoElectronico(usuario.getCorreoElectronico().toUpperCase());
            usuario.setContrasena(asignarContrasenaDeUsuario());
            usuario.setNombreUsuario(asignarNombreDeUsuario());
            usuario.setEstado("ACTIVO");
            Mailer.crearUsuario(usuario.getCorreoElectronico(), usuario.getNombreUsuario(), usuario.getContrasena());
            uF.create(usuario);
            iS.registrarLogDeAcciones(iS.getUsuarioLogueado(), "CREAR USUARIO", usuario.getNombreUsuario());
            mensajeCrearUsuario = "El usuario " + usuario.getNombreUsuario() + " ha sido creado exitosamente. Las credenciales se enviaron al correo registrado.";
        } catch (Exception e) {
            mensajeCrearUsuario = "Ocurrió un error en la ejecución, por favor intente de nuevo.";
        }
        return "";
    }

    public String asignarNombreDeUsuario() {

        Random random = new Random();
        String nuevoNombreUsuario = "";
        nuevoNombreUsuario += usuario.getPrimerNombre().substring(0, 1).toUpperCase();
        nuevoNombreUsuario += random.nextInt(10);
        nuevoNombreUsuario += usuario.getPrimerApellido().substring(0, 1).toUpperCase();
        nuevoNombreUsuario += random.nextInt(10);
        nuevoNombreUsuario += usuario.getPrimerApellido().substring(1, 2).toUpperCase();
        nuevoNombreUsuario += random.nextInt(10);
        nuevoNombreUsuario += usuario.getPrimerApellido().substring(2, 3).toUpperCase();
        nuevoNombreUsuario += random.nextInt(10);

        return nuevoNombreUsuario;
    }

    public String asignarContrasenaDeUsuario() {

        Random random = new Random();
        String nuevaContrasena = "";

        nuevaContrasena += usuario.getPrimerNombre().substring(2, 3).toLowerCase();
        nuevaContrasena += usuario.getPrimerApellido().substring(0, 1).toUpperCase();
        nuevaContrasena += random.nextInt(10);
        nuevaContrasena += random.nextInt(10);
        nuevaContrasena += usuario.getCorreoElectronico().substring(3, 4).toUpperCase();
        nuevaContrasena += "z";
        nuevaContrasena += usuario.getPrimerNombre().substring(1, 2).toUpperCase();
        nuevaContrasena += random.nextInt(10);

        return nuevaContrasena;
    }

    public List<Usuarios> traerUsuariosPorRol(String rol) {
        return uF.traerUsuariosPorRolBD(rol);
    }

    public List<String> traerNombreDeUsuariosActivos() {
        return uF.traerNombreDeUsuariosActivos();
    }

       public List<Usuarios> traerTodosLosUsuariosActivos() {
        return uF.traerTodosLosUsuariosActivos();
    }
    
    public Usuarios traerUsuario(String nombreUsuario) {
        return uF.traerUsuario(nombreUsuario);
    }

    public String getMensajeModificarUsuario() {
        return mensajeModificarUsuario;
    }

    public void setMensajeModificarUsuario(String mensajeModificarUsuario) {
        this.mensajeModificarUsuario = mensajeModificarUsuario;
    }

    public String getMensajeCrearUsuario() {
        return mensajeCrearUsuario;
    }

    public void setMensajeCrearUsuario(String mensajeCrearUsuario) {
        this.mensajeCrearUsuario = mensajeCrearUsuario;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

}
