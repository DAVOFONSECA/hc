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
@Table(name = "causasmora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Causasmora.findAll", query = "SELECT c FROM Causasmora c")
    , @NamedQuery(name = "Causasmora.findByIdCausasMora", query = "SELECT c FROM Causasmora c WHERE c.idCausasMora = :idCausasMora")
    , @NamedQuery(name = "Causasmora.findByCausaMora", query = "SELECT c FROM Causasmora c WHERE c.causaMora = :causaMora")})
public class Causasmora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCausasMora")
    private Integer idCausasMora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "causaMora")
    private String causaMora;

    public Causasmora() {
    }

    public Causasmora(Integer idCausasMora) {
        this.idCausasMora = idCausasMora;
    }

    public Causasmora(Integer idCausasMora, String causaMora) {
        this.idCausasMora = idCausasMora;
        this.causaMora = causaMora;
    }

    public Integer getIdCausasMora() {
        return idCausasMora;
    }

    public void setIdCausasMora(Integer idCausasMora) {
        this.idCausasMora = idCausasMora;
    }

    public String getCausaMora() {
        return causaMora;
    }

    public void setCausaMora(String causaMora) {
        this.causaMora = causaMora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCausasMora != null ? idCausasMora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Causasmora)) {
            return false;
        }
        Causasmora other = (Causasmora) object;
        if ((this.idCausasMora == null && other.idCausasMora != null) || (this.idCausasMora != null && !this.idCausasMora.equals(other.idCausasMora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Causasmora[ idCausasMora=" + idCausasMora + " ]";
    }
    
}
