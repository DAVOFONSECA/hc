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
@Table(name = "obligaciones_garantias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObligacionesGarantias.findAll", query = "SELECT o FROM ObligacionesGarantias o")
    , @NamedQuery(name = "ObligacionesGarantias.findByIdRelacion", query = "SELECT o FROM ObligacionesGarantias o WHERE o.idRelacion = :idRelacion")})
public class ObligacionesGarantias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelacion")
    private Integer idRelacion;
    @JoinColumn(name = "idGarantia", referencedColumnName = "idGarantia")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Garantias idGarantia;
    @JoinColumn(name = "idObligacion", referencedColumnName = "idObligacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Obligaciones idObligacion;

    public ObligacionesGarantias() {
    }

    public ObligacionesGarantias(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Garantias getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Garantias idGarantia) {
        this.idGarantia = idGarantia;
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
        if (!(object instanceof ObligacionesGarantias)) {
            return false;
        }
        ObligacionesGarantias other = (ObligacionesGarantias) object;
        if ((this.idRelacion == null && other.idRelacion != null) || (this.idRelacion != null && !this.idRelacion.equals(other.idRelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ObligacionesGarantias[ idRelacion=" + idRelacion + " ]";
    }
    
}
