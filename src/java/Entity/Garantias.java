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
@Table(name = "garantias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantias.findAll", query = "SELECT g FROM Garantias g")
    , @NamedQuery(name = "Garantias.findByIdGarantia", query = "SELECT g FROM Garantias g WHERE g.idGarantia = :idGarantia")
    , @NamedQuery(name = "Garantias.findByTipo", query = "SELECT g FROM Garantias g WHERE g.tipo = :tipo")
    , @NamedQuery(name = "Garantias.findByTipoIdentificacion", query = "SELECT g FROM Garantias g WHERE g.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Garantias.findByNumeroIdentificacion", query = "SELECT g FROM Garantias g WHERE g.numeroIdentificacion = :numeroIdentificacion")
    , @NamedQuery(name = "Garantias.findByEspecificacion", query = "SELECT g FROM Garantias g WHERE g.especificacion = :especificacion")
    , @NamedQuery(name = "Garantias.findByObservacion", query = "SELECT g FROM Garantias g WHERE g.observacion = :observacion")
    , @NamedQuery(name = "Garantias.findByEstado", query = "SELECT g FROM Garantias g WHERE g.estado = :estado")})
public class Garantias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGarantia")
    private Integer idGarantia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 50)
    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;
    @Size(max = 50)
    @Column(name = "numeroIdentificacion")
    private String numeroIdentificacion;
    @Size(max = 200)
    @Column(name = "especificacion")
    private String especificacion;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGarantia", fetch = FetchType.EAGER)
    private List<ObligacionesGarantias> obligacionesGarantiasList;

    public Garantias() {
    }

    public Garantias(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public Garantias(Integer idGarantia, String tipo, String estado) {
        this.idGarantia = idGarantia;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Integer getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(Integer idGarantia) {
        this.idGarantia = idGarantia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ObligacionesGarantias> getObligacionesGarantiasList() {
        return obligacionesGarantiasList;
    }

    public void setObligacionesGarantiasList(List<ObligacionesGarantias> obligacionesGarantiasList) {
        this.obligacionesGarantiasList = obligacionesGarantiasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGarantia != null ? idGarantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantias)) {
            return false;
        }
        Garantias other = (Garantias) object;
        if ((this.idGarantia == null && other.idGarantia != null) || (this.idGarantia != null && !this.idGarantia.equals(other.idGarantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Garantias[ idGarantia=" + idGarantia + " ]";
    }
    
}
