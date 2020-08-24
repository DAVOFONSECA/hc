/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Logdeacciones;
import Entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "HC11052020PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    
    
    public Usuarios traerUsuarioBD(Usuarios u) {
        try {
            Query q = getEntityManager().createNativeQuery("Select * from Usuarios where nombreUsuario = ?", Usuarios.class);
            q.setParameter(1, u.getNombreUsuario());
            return (Usuarios) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Logdeacciones utFechaCambioContrasena(Usuarios u) {
        try {
            Logdeacciones logdeacciones = new Logdeacciones();
            Query q = getEntityManager().createNativeQuery("Select * \n"
                    + "from logdeacciones as lg\n"
                    + "where fecha in (\n"
                    + "SELECT MAX(L.fecha)\n"
                    + "FROM logdeacciones as l \n"
                    + "	INNER JOIN usuarios as u on \n"
                    + "    l.idUsuario = u.idUsuario\n"
                    + "    where u.idUsuario = ? and \n"
                    + "    l.tipo = \"CAMBIAR CONTRASEÑA\"\n"
                    + ") and lg.idUsuario = ?\n"
                    + "and lg.tipo = \"CAMBIAR CONTRASEÑA\"", Logdeacciones.class);
            q.setParameter(1, u.getIdUsuario());
            q.setParameter(2, u.getIdUsuario());
            logdeacciones = (Logdeacciones) q.getSingleResult();
            return (Logdeacciones) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error trayendola última fecha de cambio de contraseña");
            return null;
        }

    }

    public List<Usuarios> traerUsuariosPorRolBD(String rol) {
        try {
            Query q = getEntityManager().createNativeQuery("Select * from Usuarios where rol = ? and estado  ='ACTIVO'", Usuarios.class);
            q.setParameter(1, rol);
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> traerNombreDeUsuariosActivos() {
        Query q = getEntityManager().createNativeQuery("SELECT nombreUsuario FROM `usuarios` WHERE estado = 'ACTIVO' and nombreUsuario <> 'XXXXXXXX' ORDER BY nombreUsuario");
        return q.getResultList();
    }

    public Usuarios traerUsuario(String nombreUsuario) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM `usuarios` WHERE nombreUsuario = ?", Usuarios.class);
        q.setParameter(1, nombreUsuario);
        return (Usuarios) q.getSingleResult();
    }

    public List<Usuarios> traerTodosLosUsuariosActivos() {
        Query q = getEntityManager().createNativeQuery("Select * from Usuarios where estado = 'ACTIVO'", Usuarios.class);
        return q.getResultList();
    }
}
