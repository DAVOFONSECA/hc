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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "deudores_obligaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeudoresObligaciones.findAll", query = "SELECT d FROM DeudoresObligaciones d")
    , @NamedQuery(name = "DeudoresObligaciones.findByIdRelacion", query = "SELECT d FROM DeudoresObligaciones d WHERE d.idRelacion = :idRelacion")
    , @NamedQuery(name = "DeudoresObligaciones.findByRelacion", query = "SELECT d FROM DeudoresObligaciones d WHERE d.relacion = :relacion")})
public class DeudoresObligaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelacion")
    private Integer idRelacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "relacion")
    private String relacion;
    @JoinColumn(name = "idDeudor", referencedColumnName = "idDeudor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Deudores idDeudor;
    @JoinColumn(name = "idObligacion", referencedColumnName = "idObligacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Obligaciones idObligacion;

    public DeudoresObligaciones() {
    }

    public DeudoresObligaciones(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public DeudoresObligaciones(Integer idRelacion, String relacion) {
        this.idRelacion = idRelacion;
        this.relacion = relacion;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public Deudores getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(Deudores idDeudor) {
        this.idDeudor = idDeudor;
    }

    public Obligaciones getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Obligaciones idObligacion) {
        this.idObligacion = idObligacion;
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
        if (!(object instanceof DeudoresObligaciones)) {
            return false;
        }
        DeudoresObligaciones other = (DeudoresObligaciones) object;
        if ((this.idRelacion == null && other.idRelacion != null) || (this.idRelacion != null && !this.idRelacion.equals(other.idRelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DeudoresObligaciones[ idRelacion=" + idRelacion + " ]";
    }
    
}
