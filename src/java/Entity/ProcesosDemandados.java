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
@Table(name = "procesos_demandados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesosDemandados.findAll", query = "SELECT p FROM ProcesosDemandados p")
    , @NamedQuery(name = "ProcesosDemandados.findByIdRelacion", query = "SELECT p FROM ProcesosDemandados p WHERE p.idRelacion = :idRelacion")})
public class ProcesosDemandados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRelacion")
    private Integer idRelacion;
    @JoinColumn(name = "idDeudor", referencedColumnName = "idDeudor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Deudores idDeudor;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Procesos idProceso;

    public ProcesosDemandados() {
    }

    public ProcesosDemandados(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Deudores getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(Deudores idDeudor) {
        this.idDeudor = idDeudor;
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
        if (!(object instanceof ProcesosDemandados)) {
            return false;
        }
        ProcesosDemandados other = (ProcesosDemandados) object;
        if ((this.idRelacion == null && other.idRelacion != null) || (this.idRelacion != null && !this.idRelacion.equals(other.idRelacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ProcesosDemandados[ idRelacion=" + idRelacion + " ]";
    }
    
}
