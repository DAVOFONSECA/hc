/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByIdUsuario", query = "SELECT u FROM Usuarios u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuarios.findByTipoIdentificacion", query = "SELECT u FROM Usuarios u WHERE u.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Usuarios.findByIdentificacion", query = "SELECT u FROM Usuarios u WHERE u.identificacion = :identificacion")
    , @NamedQuery(name = "Usuarios.findByDigitoVerificacion", query = "SELECT u FROM Usuarios u WHERE u.digitoVerificacion = :digitoVerificacion")
    , @NamedQuery(name = "Usuarios.findByPrimerNombre", query = "SELECT u FROM Usuarios u WHERE u.primerNombre = :primerNombre")
    , @NamedQuery(name = "Usuarios.findBySegundoNombre", query = "SELECT u FROM Usuarios u WHERE u.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Usuarios.findByPrimerApellido", query = "SELECT u FROM Usuarios u WHERE u.primerApellido = :primerApellido")
    , @NamedQuery(name = "Usuarios.findBySegundoApellido", query = "SELECT u FROM Usuarios u WHERE u.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Usuarios.findByNombreUsuario", query = "SELECT u FROM Usuarios u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuarios.findByCorreoElectronico", query = "SELECT u FROM Usuarios u WHERE u.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Usuarios.findByRol", query = "SELECT u FROM Usuarios u WHERE u.rol = :rol")
    , @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacion")
    private int identificacion;
    @Column(name = "digitoVerificacion")
    private Integer digitoVerificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDependiente", fetch = FetchType.EAGER)
    private List<Juzgados> juzgadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<Deudores> deudoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitado", fetch = FetchType.EAGER)
    private List<Solicitudes> solicitudesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitante", fetch = FetchType.EAGER)
    private List<Solicitudes> solicitudesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGestor", fetch = FetchType.EAGER)
    private List<Gestionesjuridicas> gestionesjuridicasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<Actuacionesnotificaciones> actuacionesnotificacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<Logdeacciones> logdeaccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<Actuacionescartasvisitas> actuacionescartasvisitasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<Actuacionesmedidas> actuacionesmedidasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<Gestionescomerciales> gestionescomercialesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGestor", fetch = FetchType.EAGER)
    private List<Procesos> procesosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<Actuacionessolicitudes> actuacionessolicitudesList;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuarios(Integer idUsuario, String tipoIdentificacion, int identificacion, String primerNombre, String primerApellido, String nombreUsuario, String contrasena, String correoElectronico, String rol, String estado) {
        this.idUsuario = idUsuario;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(Integer digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Juzgados> getJuzgadosList() {
        return juzgadosList;
    }

    public void setJuzgadosList(List<Juzgados> juzgadosList) {
        this.juzgadosList = juzgadosList;
    }

    @XmlTransient
    public List<Deudores> getDeudoresList() {
        return deudoresList;
    }

    public void setDeudoresList(List<Deudores> deudoresList) {
        this.deudoresList = deudoresList;
    }

    @XmlTransient
    public List<Solicitudes> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitudes> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

    @XmlTransient
    public List<Solicitudes> getSolicitudesList1() {
        return solicitudesList1;
    }

    public void setSolicitudesList1(List<Solicitudes> solicitudesList1) {
        this.solicitudesList1 = solicitudesList1;
    }

    @XmlTransient
    public List<Gestionesjuridicas> getGestionesjuridicasList() {
        return gestionesjuridicasList;
    }

    public void setGestionesjuridicasList(List<Gestionesjuridicas> gestionesjuridicasList) {
        this.gestionesjuridicasList = gestionesjuridicasList;
    }

    @XmlTransient
    public List<Actuacionesnotificaciones> getActuacionesnotificacionesList() {
        return actuacionesnotificacionesList;
    }

    public void setActuacionesnotificacionesList(List<Actuacionesnotificaciones> actuacionesnotificacionesList) {
        this.actuacionesnotificacionesList = actuacionesnotificacionesList;
    }

    @XmlTransient
    public List<Logdeacciones> getLogdeaccionesList() {
        return logdeaccionesList;
    }

    public void setLogdeaccionesList(List<Logdeacciones> logdeaccionesList) {
        this.logdeaccionesList = logdeaccionesList;
    }

    @XmlTransient
    public List<Actuacionescartasvisitas> getActuacionescartasvisitasList() {
        return actuacionescartasvisitasList;
    }

    public void setActuacionescartasvisitasList(List<Actuacionescartasvisitas> actuacionescartasvisitasList) {
        this.actuacionescartasvisitasList = actuacionescartasvisitasList;
    }

    @XmlTransient
    public List<Actuacionesmedidas> getActuacionesmedidasList() {
        return actuacionesmedidasList;
    }

    public void setActuacionesmedidasList(List<Actuacionesmedidas> actuacionesmedidasList) {
        this.actuacionesmedidasList = actuacionesmedidasList;
    }

    @XmlTransient
    public List<Gestionescomerciales> getGestionescomercialesList() {
        return gestionescomercialesList;
    }

    public void setGestionescomercialesList(List<Gestionescomerciales> gestionescomercialesList) {
        this.gestionescomercialesList = gestionescomercialesList;
    }

    @XmlTransient
    public List<Procesos> getProcesosList() {
        return procesosList;
    }

    public void setProcesosList(List<Procesos> procesosList) {
        this.procesosList = procesosList;
    }

    @XmlTransient
    public List<Actuacionessolicitudes> getActuacionessolicitudesList() {
        return actuacionessolicitudesList;
    }

    public void setActuacionessolicitudesList(List<Actuacionessolicitudes> actuacionessolicitudesList) {
        this.actuacionessolicitudesList = actuacionessolicitudesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Usuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
