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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cartasvisitas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartasvisitas.findAll", query = "SELECT c FROM Cartasvisitas c")
    , @NamedQuery(name = "Cartasvisitas.findByIdCartasVisitas", query = "SELECT c FROM Cartasvisitas c WHERE c.idCartasVisitas = :idCartasVisitas")
    , @NamedQuery(name = "Cartasvisitas.findByGuia", query = "SELECT c FROM Cartasvisitas c WHERE c.guia = :guia")
    , @NamedQuery(name = "Cartasvisitas.findByCourrier", query = "SELECT c FROM Cartasvisitas c WHERE c.courrier = :courrier")
    , @NamedQuery(name = "Cartasvisitas.findByTipo", query = "SELECT c FROM Cartasvisitas c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Cartasvisitas.findByEncargado", query = "SELECT c FROM Cartasvisitas c WHERE c.encargado = :encargado")
    , @NamedQuery(name = "Cartasvisitas.findByObservaciones", query = "SELECT c FROM Cartasvisitas c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "Cartasvisitas.findByEstado", query = "SELECT c FROM Cartasvisitas c WHERE c.estado = :estado")})
public class Cartasvisitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCartasVisitas")
    private Integer idCartasVisitas;
    @Size(max = 20)
    @Column(name = "guia")
    private String guia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "courrier")
    private String courrier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 50)
    @Column(name = "encargado")
    private String encargado;
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCartasVisitas", fetch = FetchType.EAGER)
    private List<Actuacionescartasvisitas> actuacionescartasvisitasList;
    @JoinColumn(name = "idDireccion", referencedColumnName = "idDireccion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Direcciones idDireccion;

    public Cartasvisitas() {
    }

    public Cartasvisitas(Integer idCartasVisitas) {
        this.idCartasVisitas = idCartasVisitas;
    }

    public Cartasvisitas(Integer idCartasVisitas, String courrier, String tipo, String estado) {
        this.idCartasVisitas = idCartasVisitas;
        this.courrier = courrier;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Integer getIdCartasVisitas() {
        return idCartasVisitas;
    }

    public void setIdCartasVisitas(Integer idCartasVisitas) {
        this.idCartasVisitas = idCartasVisitas;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getCourrier() {
        return courrier;
    }

    public void setCourrier(String courrier) {
        this.courrier = courrier;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Actuacionescartasvisitas> getActuacionescartasvisitasList() {
        return actuacionescartasvisitasList;
    }

    public void setActuacionescartasvisitasList(List<Actuacionescartasvisitas> actuacionescartasvisitasList) {
        this.actuacionescartasvisitasList = actuacionescartasvisitasList;
    }

    public Direcciones getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direcciones idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartasVisitas != null ? idCartasVisitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartasvisitas)) {
            return false;
        }
        Cartasvisitas other = (Cartasvisitas) object;
        if ((this.idCartasVisitas == null && other.idCartasVisitas != null) || (this.idCartasVisitas != null && !this.idCartasVisitas.equals(other.idCartasVisitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cartasvisitas[ idCartasVisitas=" + idCartasVisitas + " ]";
    }
    
}
