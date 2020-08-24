/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "actuacionesnotificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actuacionesnotificaciones.findAll", query = "SELECT a FROM Actuacionesnotificaciones a")
    , @NamedQuery(name = "Actuacionesnotificaciones.findByIdActuacionNotificacion", query = "SELECT a FROM Actuacionesnotificaciones a WHERE a.idActuacionNotificacion = :idActuacionNotificacion")
    , @NamedQuery(name = "Actuacionesnotificaciones.findByFechaGestion", query = "SELECT a FROM Actuacionesnotificaciones a WHERE a.fechaGestion = :fechaGestion")
    , @NamedQuery(name = "Actuacionesnotificaciones.findByFechaActuacion", query = "SELECT a FROM Actuacionesnotificaciones a WHERE a.fechaActuacion = :fechaActuacion")
    , @NamedQuery(name = "Actuacionesnotificaciones.findByGestion", query = "SELECT a FROM Actuacionesnotificaciones a WHERE a.gestion = :gestion")
    , @NamedQuery(name = "Actuacionesnotificaciones.findByResultado", query = "SELECT a FROM Actuacionesnotificaciones a WHERE a.resultado = :resultado")
    , @NamedQuery(name = "Actuacionesnotificaciones.findByObservacion", query = "SELECT a FROM Actuacionesnotificaciones a WHERE a.observacion = :observacion")})
public class Actuacionesnotificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idActuacionNotificacion")
    private Integer idActuacionNotificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaGestion")
    @Temporal(TemporalType.DATE)
    private Date fechaGestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaActuacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActuacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gestion")
    private String gestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "resultado")
    private String resultado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Observacion")
    private String observacion;
    @JoinColumn(name = "idNotificacion", referencedColumnName = "idNotificacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Notificaciones idNotificacion;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idUsuario;

    public Actuacionesnotificaciones() {
    }

    public Actuacionesnotificaciones(Integer idActuacionNotificacion) {
        this.idActuacionNotificacion = idActuacionNotificacion;
    }

    public Actuacionesnotificaciones(Integer idActuacionNotificacion, Date fechaGestion, Date fechaActuacion, String gestion, String resultado, String observacion) {
        this.idActuacionNotificacion = idActuacionNotificacion;
        this.fechaGestion = fechaGestion;
        this.fechaActuacion = fechaActuacion;
        this.gestion = gestion;
        this.resultado = resultado;
        this.observacion = observacion;
    }

    public Integer getIdActuacionNotificacion() {
        return idActuacionNotificacion;
    }

    public void setIdActuacionNotificacion(Integer idActuacionNotificacion) {
        this.idActuacionNotificacion = idActuacionNotificacion;
    }

    public Date getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public Date getFechaActuacion() {
        return fechaActuacion;
    }

    public void setFechaActuacion(Date fechaActuacion) {
        this.fechaActuacion = fechaActuacion;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Notificaciones getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Notificaciones idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActuacionNotificacion != null ? idActuacionNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actuacionesnotificaciones)) {
            return false;
        }
        Actuacionesnotificaciones other = (Actuacionesnotificaciones) object;
        if ((this.idActuacionNotificacion == null && other.idActuacionNotificacion != null) || (this.idActuacionNotificacion != null && !this.idActuacionNotificacion.equals(other.idActuacionNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Actuacionesnotificaciones[ idActuacionNotificacion=" + idActuacionNotificacion + " ]";
    }
    
}
