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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "notificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaciones.findAll", query = "SELECT n FROM Notificaciones n")
    , @NamedQuery(name = "Notificaciones.findByIdNotificacion", query = "SELECT n FROM Notificaciones n WHERE n.idNotificacion = :idNotificacion")
    , @NamedQuery(name = "Notificaciones.findByGuia", query = "SELECT n FROM Notificaciones n WHERE n.guia = :guia")
    , @NamedQuery(name = "Notificaciones.findByCourrier", query = "SELECT n FROM Notificaciones n WHERE n.courrier = :courrier")
    , @NamedQuery(name = "Notificaciones.findByTipo", query = "SELECT n FROM Notificaciones n WHERE n.tipo = :tipo")
    , @NamedQuery(name = "Notificaciones.findByEstado", query = "SELECT n FROM Notificaciones n WHERE n.estado = :estado")
    , @NamedQuery(name = "Notificaciones.findByEncargado", query = "SELECT n FROM Notificaciones n WHERE n.encargado = :encargado")
    , @NamedQuery(name = "Notificaciones.findByObservaciones", query = "SELECT n FROM Notificaciones n WHERE n.observaciones = :observaciones")})
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotificacion")
    private Integer idNotificacion;
    @Size(max = 20)
    @Column(name = "guia")
    private String guia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "courrier")
    private String courrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @Size(max = 50)
    @Column(name = "encargado")
    private String encargado;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNotificacion", fetch = FetchType.EAGER)
    private List<Actuacionesnotificaciones> actuacionesnotificacionesList;
    @JoinColumn(name = "idDireccion", referencedColumnName = "idDireccion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Direcciones idDireccion;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Procesos idProceso;

    public Notificaciones() {
    }

    public Notificaciones(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Notificaciones(Integer idNotificacion, String courrier, String tipo, String estado) {
        this.idNotificacion = idNotificacion;
        this.courrier = courrier;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getCourrier() {
        return courrier;
    }

    public void setCourrier(String courrier) {
        this.courrier = courrier;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Actuacionesnotificaciones> getActuacionesnotificacionesList() {
        return actuacionesnotificacionesList;
    }

    public void setActuacionesnotificacionesList(List<Actuacionesnotificaciones> actuacionesnotificacionesList) {
        this.actuacionesnotificacionesList = actuacionesnotificacionesList;
    }

    public Direcciones getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direcciones idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Procesos getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Procesos idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacion != null ? idNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificaciones)) {
            return false;
        }
        Notificaciones other = (Notificaciones) object;
        if ((this.idNotificacion == null && other.idNotificacion != null) || (this.idNotificacion != null && !this.idNotificacion.equals(other.idNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Notificaciones[ idNotificacion=" + idNotificacion + " ]";
    }
    
}
