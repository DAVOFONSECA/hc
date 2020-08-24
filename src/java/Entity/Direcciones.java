/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d")
    , @NamedQuery(name = "Direcciones.findByIdDireccion", query = "SELECT d FROM Direcciones d WHERE d.idDireccion = :idDireccion")
    , @NamedQuery(name = "Direcciones.findByTipo", query = "SELECT d FROM Direcciones d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "Direcciones.findByDireccion", query = "SELECT d FROM Direcciones d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "Direcciones.findByBarrio", query = "SELECT d FROM Direcciones d WHERE d.barrio = :barrio")
    , @NamedQuery(name = "Direcciones.findByLocalidad", query = "SELECT d FROM Direcciones d WHERE d.localidad = :localidad")
    , @NamedQuery(name = "Direcciones.findByLugar", query = "SELECT d FROM Direcciones d WHERE d.lugar = :lugar")
    , @NamedQuery(name = "Direcciones.findByCorrespondencia", query = "SELECT d FROM Direcciones d WHERE d.correspondencia = :correspondencia")
    , @NamedQuery(name = "Direcciones.findByNotificacion", query = "SELECT d FROM Direcciones d WHERE d.notificacion = :notificacion")
    , @NamedQuery(name = "Direcciones.findByFechaUltimaActualizacion", query = "SELECT d FROM Direcciones d WHERE d.fechaUltimaActualizacion = :fechaUltimaActualizacion")
    , @NamedQuery(name = "Direcciones.findByIntentos", query = "SELECT d FROM Direcciones d WHERE d.intentos = :intentos")
    , @NamedQuery(name = "Direcciones.findByIntentosEfectivos", query = "SELECT d FROM Direcciones d WHERE d.intentosEfectivos = :intentosEfectivos")
    , @NamedQuery(name = "Direcciones.findByEstado", query = "SELECT d FROM Direcciones d WHERE d.estado = :estado")})
public class Direcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccion")
    private Integer idDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 50)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugar")
    private String lugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "correspondencia")
    private String correspondencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "notificacion")
    private String notificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaUltimaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaActualizacion;
    @Column(name = "intentos")
    private Integer intentos;
    @Column(name = "intentosEfectivos")
    private Integer intentosEfectivos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Ciudades idCiudad;
    @JoinColumn(name = "idDeudor", referencedColumnName = "idDeudor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Deudores idDeudor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDireccion", fetch = FetchType.EAGER)
    private List<Cartasvisitas> cartasvisitasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDireccion", fetch = FetchType.EAGER)
    private List<Notificaciones> notificacionesList;

    public Direcciones() {
    }

    public Direcciones(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Direcciones(Integer idDireccion, String tipo, String direccion, String lugar, String correspondencia, String notificacion, Date fechaUltimaActualizacion, String estado) {
        this.idDireccion = idDireccion;
        this.tipo = tipo;
        this.direccion = direccion;
        this.lugar = lugar;
        this.correspondencia = correspondencia;
        this.notificacion = notificacion;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.estado = estado;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCorrespondencia() {
        return correspondencia;
    }

    public void setCorrespondencia(String correspondencia) {
        this.correspondencia = correspondencia;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Integer getIntentosEfectivos() {
        return intentosEfectivos;
    }

    public void setIntentosEfectivos(Integer intentosEfectivos) {
        this.intentosEfectivos = intentosEfectivos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Deudores getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(Deudores idDeudor) {
        this.idDeudor = idDeudor;
    }

    @XmlTransient
    public List<Cartasvisitas> getCartasvisitasList() {
        return cartasvisitasList;
    }

    public void setCartasvisitasList(List<Cartasvisitas> cartasvisitasList) {
        this.cartasvisitasList = cartasvisitasList;
    }

    @XmlTransient
    public List<Notificaciones> getNotificacionesList() {
        return notificacionesList;
    }

    public void setNotificacionesList(List<Notificaciones> notificacionesList) {
        this.notificacionesList = notificacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Direcciones[ idDireccion=" + idDireccion + " ]";
    }
    
}
