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
@Table(name = "actuacionessolicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actuacionessolicitudes.findAll", query = "SELECT a FROM Actuacionessolicitudes a")
    , @NamedQuery(name = "Actuacionessolicitudes.findByIdActuacionSolciitud", query = "SELECT a FROM Actuacionessolicitudes a WHERE a.idActuacionSolciitud = :idActuacionSolciitud")
    , @NamedQuery(name = "Actuacionessolicitudes.findByFechaGestion", query = "SELECT a FROM Actuacionessolicitudes a WHERE a.fechaGestion = :fechaGestion")
    , @NamedQuery(name = "Actuacionessolicitudes.findByFechaActuacion", query = "SELECT a FROM Actuacionessolicitudes a WHERE a.fechaActuacion = :fechaActuacion")
    , @NamedQuery(name = "Actuacionessolicitudes.findByGestion", query = "SELECT a FROM Actuacionessolicitudes a WHERE a.gestion = :gestion")
    , @NamedQuery(name = "Actuacionessolicitudes.findByObservaciones", query = "SELECT a FROM Actuacionessolicitudes a WHERE a.observaciones = :observaciones")})
public class Actuacionessolicitudes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idActuacionSolciitud")
    private Integer idActuacionSolciitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaGestion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaActuacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActuacion;
    @Size(max = 50)
    @Column(name = "gestion")
    private String gestion;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idsolicitud", referencedColumnName = "idSolicitud")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Solicitudes idsolicitud;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idUsuario;

    public Actuacionessolicitudes() {
    }

    public Actuacionessolicitudes(Integer idActuacionSolciitud) {
        this.idActuacionSolciitud = idActuacionSolciitud;
    }

    public Actuacionessolicitudes(Integer idActuacionSolciitud, Date fechaGestion, Date fechaActuacion) {
        this.idActuacionSolciitud = idActuacionSolciitud;
        this.fechaGestion = fechaGestion;
        this.fechaActuacion = fechaActuacion;
    }

    public Integer getIdActuacionSolciitud() {
        return idActuacionSolciitud;
    }

    public void setIdActuacionSolciitud(Integer idActuacionSolciitud) {
        this.idActuacionSolciitud = idActuacionSolciitud;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Solicitudes getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Solicitudes idsolicitud) {
        this.idsolicitud = idsolicitud;
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
        hash += (idActuacionSolciitud != null ? idActuacionSolciitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actuacionessolicitudes)) {
            return false;
        }
        Actuacionessolicitudes other = (Actuacionessolicitudes) object;
        if ((this.idActuacionSolciitud == null && other.idActuacionSolciitud != null) || (this.idActuacionSolciitud != null && !this.idActuacionSolciitud.equals(other.idActuacionSolciitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Actuacionessolicitudes[ idActuacionSolciitud=" + idActuacionSolciitud + " ]";
    }
    
}
