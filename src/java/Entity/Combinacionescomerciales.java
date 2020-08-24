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
@Table(name = "combinacionescomerciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combinacionescomerciales.findAll", query = "SELECT c FROM Combinacionescomerciales c")
    , @NamedQuery(name = "Combinacionescomerciales.findByIdCombinacionesComerciales", query = "SELECT c FROM Combinacionescomerciales c WHERE c.idCombinacionesComerciales = :idCombinacionesComerciales")
    , @NamedQuery(name = "Combinacionescomerciales.findByGestion", query = "SELECT c FROM Combinacionescomerciales c WHERE c.gestion = :gestion")
    , @NamedQuery(name = "Combinacionescomerciales.findByResultado", query = "SELECT c FROM Combinacionescomerciales c WHERE c.resultado = :resultado")
    , @NamedQuery(name = "Combinacionescomerciales.findByContacto", query = "SELECT c FROM Combinacionescomerciales c WHERE c.contacto = :contacto")})
public class Combinacionescomerciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCombinacionesComerciales")
    private Integer idCombinacionesComerciales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gestion")
    private String gestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "resultado")
    private String resultado;
    @Size(max = 50)
    @Column(name = "contacto")
    private String contacto;

    public Combinacionescomerciales() {
    }

    public Combinacionescomerciales(Integer idCombinacionesComerciales) {
        this.idCombinacionesComerciales = idCombinacionesComerciales;
    }

    public Combinacionescomerciales(Integer idCombinacionesComerciales, String gestion, String resultado) {
        this.idCombinacionesComerciales = idCombinacionesComerciales;
        this.gestion = gestion;
        this.resultado = resultado;
    }

    public Integer getIdCombinacionesComerciales() {
        return idCombinacionesComerciales;
    }

    public void setIdCombinacionesComerciales(Integer idCombinacionesComerciales) {
        this.idCombinacionesComerciales = idCombinacionesComerciales;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCombinacionesComerciales != null ? idCombinacionesComerciales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combinacionescomerciales)) {
            return false;
        }
        Combinacionescomerciales other = (Combinacionescomerciales) object;
        if ((this.idCombinacionesComerciales == null && other.idCombinacionesComerciales != null) || (this.idCombinacionesComerciales != null && !this.idCombinacionesComerciales.equals(other.idCombinacionesComerciales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Combinacionescomerciales[ idCombinacionesComerciales=" + idCombinacionesComerciales + " ]";
    }
    
}
