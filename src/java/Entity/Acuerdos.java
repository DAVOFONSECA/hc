/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "acuerdos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acuerdos.findAll", query = "SELECT a FROM Acuerdos a")
    , @NamedQuery(name = "Acuerdos.findByIdAcuerdo", query = "SELECT a FROM Acuerdos a WHERE a.idAcuerdo = :idAcuerdo")
    , @NamedQuery(name = "Acuerdos.findByTipo", query = "SELECT a FROM Acuerdos a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Acuerdos.findByFechaCreacion", query = "SELECT a FROM Acuerdos a WHERE a.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Acuerdos.findByPlazo", query = "SELECT a FROM Acuerdos a WHERE a.plazo = :plazo")
    , @NamedQuery(name = "Acuerdos.findByEstado", query = "SELECT a FROM Acuerdos a WHERE a.estado = :estado")})
public class Acuerdos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAcuerdo")
    private Integer idAcuerdo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazo")
    private int plazo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idObligacion", referencedColumnName = "idObligacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Obligaciones idObligacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcuerdo", fetch = FetchType.EAGER)
    private List<Cuotasacuerdos> cuotasacuerdosList;

    public Acuerdos() {
    }

    public Acuerdos(Integer idAcuerdo) {
        this.idAcuerdo = idAcuerdo;
    }

    public Acuerdos(Integer idAcuerdo, String tipo, Date fechaCreacion, int plazo, String estado) {
        this.idAcuerdo = idAcuerdo;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.plazo = plazo;
        this.estado = estado;
    }

    public Integer getIdAcuerdo() {
        return idAcuerdo;
    }

    public void setIdAcuerdo(Integer idAcuerdo) {
        this.idAcuerdo = idAcuerdo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Obligaciones getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Obligaciones idObligacion) {
        this.idObligacion = idObligacion;
    }

    @XmlTransient
    public List<Cuotasacuerdos> getCuotasacuerdosList() {
        return cuotasacuerdosList;
    }

    public void setCuotasacuerdosList(List<Cuotasacuerdos> cuotasacuerdosList) {
        this.cuotasacuerdosList = cuotasacuerdosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcuerdo != null ? idAcuerdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acuerdos)) {
            return false;
        }
        Acuerdos other = (Acuerdos) object;
        if ((this.idAcuerdo == null && other.idAcuerdo != null) || (this.idAcuerdo != null && !this.idAcuerdo.equals(other.idAcuerdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Acuerdos[ idAcuerdo=" + idAcuerdo + " ]";
    }
    
}
