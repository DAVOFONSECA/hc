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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "combinacionesjudiciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combinacionesjudiciales.findAll", query = "SELECT c FROM Combinacionesjudiciales c")
    , @NamedQuery(name = "Combinacionesjudiciales.findByIdCombinacionesJudiciales", query = "SELECT c FROM Combinacionesjudiciales c WHERE c.idCombinacionesJudiciales = :idCombinacionesJudiciales")
    , @NamedQuery(name = "Combinacionesjudiciales.findByEtapa", query = "SELECT c FROM Combinacionesjudiciales c WHERE c.etapa = :etapa")
    , @NamedQuery(name = "Combinacionesjudiciales.findBySubEtapa", query = "SELECT c FROM Combinacionesjudiciales c WHERE c.subEtapa = :subEtapa")
    , @NamedQuery(name = "Combinacionesjudiciales.findByDiasTerminos", query = "SELECT c FROM Combinacionesjudiciales c WHERE c.diasTerminos = :diasTerminos")})
public class Combinacionesjudiciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCombinacionesJudiciales")
    private Integer idCombinacionesJudiciales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "etapa")
    private String etapa;
    @Size(max = 50)
    @Column(name = "subEtapa")
    private String subEtapa;
    @Column(name = "diasTerminos")
    private Integer diasTerminos;

    public Combinacionesjudiciales() {
    }

    public Combinacionesjudiciales(Integer idCombinacionesJudiciales) {
        this.idCombinacionesJudiciales = idCombinacionesJudiciales;
    }

    public Combinacionesjudiciales(Integer idCombinacionesJudiciales, String etapa) {
        this.idCombinacionesJudiciales = idCombinacionesJudiciales;
        this.etapa = etapa;
    }

    public Integer getIdCombinacionesJudiciales() {
        return idCombinacionesJudiciales;
    }

    public void setIdCombinacionesJudiciales(Integer idCombinacionesJudiciales) {
        this.idCombinacionesJudiciales = idCombinacionesJudiciales;
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

    public Integer getDiasTerminos() {
        return diasTerminos;
    }

    public void setDiasTerminos(Integer diasTerminos) {
        this.diasTerminos = diasTerminos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCombinacionesJudiciales != null ? idCombinacionesJudiciales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combinacionesjudiciales)) {
            return false;
        }
        Combinacionesjudiciales other = (Combinacionesjudiciales) object;
        if ((this.idCombinacionesJudiciales == null && other.idCombinacionesJudiciales != null) || (this.idCombinacionesJudiciales != null && !this.idCombinacionesJudiciales.equals(other.idCombinacionesJudiciales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Combinacionesjudiciales[ idCombinacionesJudiciales=" + idCombinacionesJudiciales + " ]";
    }
    
}
