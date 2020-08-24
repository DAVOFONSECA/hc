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
@Table(name = "juzgados_procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuzgadosProcesos.findAll", query = "SELECT j FROM JuzgadosProcesos j")
    , @NamedQuery(name = "JuzgadosProcesos.findByIdRelacion", query = "SELECT j FROM JuzgadosProcesos j WHERE j.idRelacion = :idRelacion")
    , @NamedQuery(name = "JuzgadosProcesos.findByFechaIngreso", query = "SELECT j FROM JuzgadosProcesos j WHERE j.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "JuzgadosProcesos.findByRelacion", query = "SELECT j FROM JuzgadosProcesos j WHERE j.relacion = :relacion")
    , @NamedQuery(name = "JuzgadosProcesos.findByObservacion", query = "SELECT j FROM JuzgadosProcesos j WHERE j.observacion = :observacion")})
public class JuzgadosProcesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelacion")
    private Integer idRelacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "relacion")
    private String relacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idJuzgado", referencedColumnName = "idJuzgado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Juzgados idJuzgado;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Procesos idProceso;

    public JuzgadosProcesos() {
    }

    public JuzgadosProcesos(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public JuzgadosProcesos(Integer idRelacion, Date fechaIngreso, String relacion, String observacion) {
        this.idRelacion = idRelacion;
        this.fechaIngreso = fechaIngreso;
        this.relacion = relacion;
        this.observacion = observacion;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Juzgados getIdJuzgado() {
        return idJuzgado;
    }

    public void setIdJuzgado(Juzgados idJuzgado) {
        this.idJuzgado = idJuzgado;
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
        hash += (idRelacion != null ? idRelacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuzgadosProcesos)) {
            return false;
        }
        JuzgadosProcesos other = (JuzgadosProcesos) object;
        if ((this.idRelacion == null && other.idRelacion != null) || (this.idRelacion != null && !this.idRelacion.equals(other.idRelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.JuzgadosProcesos[ idRelacion=" + idRelacion + " ]";
    }
    
}
