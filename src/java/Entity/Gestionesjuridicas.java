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
@Table(name = "gestionesjuridicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionesjuridicas.findAll", query = "SELECT g FROM Gestionesjuridicas g")
    , @NamedQuery(name = "Gestionesjuridicas.findByIdGestion", query = "SELECT g FROM Gestionesjuridicas g WHERE g.idGestion = :idGestion")
    , @NamedQuery(name = "Gestionesjuridicas.findByFechaGestion", query = "SELECT g FROM Gestionesjuridicas g WHERE g.fechaGestion = :fechaGestion")
    , @NamedQuery(name = "Gestionesjuridicas.findByEtapa", query = "SELECT g FROM Gestionesjuridicas g WHERE g.etapa = :etapa")
    , @NamedQuery(name = "Gestionesjuridicas.findBySubEtapa", query = "SELECT g FROM Gestionesjuridicas g WHERE g.subEtapa = :subEtapa")
    , @NamedQuery(name = "Gestionesjuridicas.findByObservacion", query = "SELECT g FROM Gestionesjuridicas g WHERE g.observacion = :observacion")
    , @NamedQuery(name = "Gestionesjuridicas.findByFecha", query = "SELECT g FROM Gestionesjuridicas g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "Gestionesjuridicas.findByFechaEstado", query = "SELECT g FROM Gestionesjuridicas g WHERE g.fechaEstado = :fechaEstado")
    , @NamedQuery(name = "Gestionesjuridicas.findByAdjuntos", query = "SELECT g FROM Gestionesjuridicas g WHERE g.adjuntos = :adjuntos")})
public class Gestionesjuridicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGestion")
    private Integer idGestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaGestion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "etapa")
    private String etapa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subEtapa")
    private String subEtapa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEstado")
    @Temporal(TemporalType.DATE)
    private Date fechaEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adjuntos")
    private String adjuntos;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Procesos idProceso;
    @JoinColumn(name = "idGestor", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idGestor;

    public Gestionesjuridicas() {
    }

    public Gestionesjuridicas(Integer idGestion) {
        this.idGestion = idGestion;
    }

    public Gestionesjuridicas(Integer idGestion, Date fechaGestion, String etapa, String subEtapa, String observacion, Date fecha, Date fechaEstado, String adjuntos) {
        this.idGestion = idGestion;
        this.fechaGestion = fechaGestion;
        this.etapa = etapa;
        this.subEtapa = subEtapa;
        this.observacion = observacion;
        this.fecha = fecha;
        this.fechaEstado = fechaEstado;
        this.adjuntos = adjuntos;
    }

    public Integer getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(Integer idGestion) {
        this.idGestion = idGestion;
    }

    public Date getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getSubEtapa() {
        return subEtapa;
    }

    public void setSubEtapa(String subEtapa) {
        this.subEtapa = subEtapa;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public String getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(String adjuntos) {
        this.adjuntos = adjuntos;
    }

    public Procesos getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Procesos idProceso) {
        this.idProceso = idProceso;
    }

    public Usuarios getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(Usuarios idGestor) {
        this.idGestor = idGestor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestion != null ? idGestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionesjuridicas)) {
            return false;
        }
        Gestionesjuridicas other = (Gestionesjuridicas) object;
        if ((this.idGestion == null && other.idGestion != null) || (this.idGestion != null && !this.idGestion.equals(other.idGestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Gestionesjuridicas[ idGestion=" + idGestion + " ]";
    }
    
}
