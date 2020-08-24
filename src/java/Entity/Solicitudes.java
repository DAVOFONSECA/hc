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
@Table(name = "solicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudes.findAll", query = "SELECT s FROM Solicitudes s")
    , @NamedQuery(name = "Solicitudes.findByIdSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Solicitudes.findByFechaSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.fechaSolicitud = :fechaSolicitud")
    , @NamedQuery(name = "Solicitudes.findByFechaLimite", query = "SELECT s FROM Solicitudes s WHERE s.fechaLimite = :fechaLimite")
    , @NamedQuery(name = "Solicitudes.findByTipoSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.tipoSolicitud = :tipoSolicitud")
    , @NamedQuery(name = "Solicitudes.findBySubTipoSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.subTipoSolicitud = :subTipoSolicitud")
    , @NamedQuery(name = "Solicitudes.findByEntidadODestinatario", query = "SELECT s FROM Solicitudes s WHERE s.entidadODestinatario = :entidadODestinatario")
    , @NamedQuery(name = "Solicitudes.findByObservaciones", query = "SELECT s FROM Solicitudes s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "Solicitudes.findByEstado", query = "SELECT s FROM Solicitudes s WHERE s.estado = :estado")})
public class Solicitudes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Column(name = "fechaLimite")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipoSolicitud")
    private String tipoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "subTipoSolicitud")
    private String subTipoSolicitud;
    @Size(max = 50)
    @Column(name = "entidadODestinatario")
    private String entidadODestinatario;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idDeudor", referencedColumnName = "idDeudor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Deudores idDeudor;
    @JoinColumn(name = "idSolicitado", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idSolicitado;
    @JoinColumn(name = "idSolicitante", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idSolicitante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitud", fetch = FetchType.EAGER)
    private List<Actuacionessolicitudes> actuacionessolicitudesList;

    public Solicitudes() {
    }

    public Solicitudes(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitudes(Integer idSolicitud, Date fechaSolicitud, String tipoSolicitud, String subTipoSolicitud, String estado) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.subTipoSolicitud = subTipoSolicitud;
        this.estado = estado;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getSubTipoSolicitud() {
        return subTipoSolicitud;
    }

    public void setSubTipoSolicitud(String subTipoSolicitud) {
        this.subTipoSolicitud = subTipoSolicitud;
    }

    public String getEntidadODestinatario() {
        return entidadODestinatario;
    }

    public void setEntidadODestinatario(String entidadODestinatario) {
        this.entidadODestinatario = entidadODestinatario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Deudores getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(Deudores idDeudor) {
        this.idDeudor = idDeudor;
    }

    public Usuarios getIdSolicitado() {
        return idSolicitado;
    }

    public void setIdSolicitado(Usuarios idSolicitado) {
        this.idSolicitado = idSolicitado;
    }

    public Usuarios getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Usuarios idSolicitante) {
        this.idSolicitante = idSolicitante;
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
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudes)) {
            return false;
        }
        Solicitudes other = (Solicitudes) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Solicitudes[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
