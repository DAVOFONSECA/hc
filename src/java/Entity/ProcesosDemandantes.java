/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "procesos_demandantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesosDemandantes.findAll", query = "SELECT p FROM ProcesosDemandantes p")
    , @NamedQuery(name = "ProcesosDemandantes.findByIdRelacion", query = "SELECT p FROM ProcesosDemandantes p WHERE p.idRelacion = :idRelacion")})
public class ProcesosDemandantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelacion")
    private Integer idRelacion;
    @JoinColumn(name = "idEntidad", referencedColumnName = "idEntidad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Entidades idEntidad;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Procesos idProceso;

    public ProcesosDemandantes() {
    }

    public ProcesosDemandantes(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
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
        if (!(object instanceof ProcesosDemandantes)) {
            return false;
        }
        ProcesosDemandantes other = (ProcesosDemandantes) object;
        if ((this.idRelacion == null && other.idRelacion != null) || (this.idRelacion != null && !this.idRelacion.equals(other.idRelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProcesosDemandantes[ idRelacion=" + idRelacion + " ]";
    }
    
}
