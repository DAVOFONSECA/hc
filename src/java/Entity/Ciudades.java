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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c")
    , @NamedQuery(name = "Ciudades.findByIdCiudad", query = "SELECT c FROM Ciudades c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudades.findByCiudad", query = "SELECT c FROM Ciudades c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Ciudades.findByDepartamento", query = "SELECT c FROM Ciudades c WHERE c.departamento = :departamento")})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCiudad")
    private Integer idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "departamento")
    private String departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private List<Juzgados> juzgadosList;
    @OneToMany(mappedBy = "idCiudad", fetch = FetchType.EAGER)
    private List<Direcciones> direccionesList;

    public Ciudades() {
    }

    public Ciudades(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudades(Integer idCiudad, String ciudad, String departamento) {
        this.idCiudad = idCiudad;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @XmlTransient
    public List<Juzgados> getJuzgadosList() {
        return juzgadosList;
    }

    public void setJuzgadosList(List<Juzgados> juzgadosList) {
        this.juzgadosList = juzgadosList;
    }

    @XmlTransient
    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ciudades[ idCiudad=" + idCiudad + " ]";
    }
    
}
