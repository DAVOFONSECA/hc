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
@Table(name = "entidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidades.findAll", query = "SELECT e FROM Entidades e")
    , @NamedQuery(name = "Entidades.findByIdEntidad", query = "SELECT e FROM Entidades e WHERE e.idEntidad = :idEntidad")
    , @NamedQuery(name = "Entidades.findByTipoIdentificacion", query = "SELECT e FROM Entidades e WHERE e.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Entidades.findByIdentificacion", query = "SELECT e FROM Entidades e WHERE e.identificacion = :identificacion")
    , @NamedQuery(name = "Entidades.findByDigitoVerificacion", query = "SELECT e FROM Entidades e WHERE e.digitoVerificacion = :digitoVerificacion")
    , @NamedQuery(name = "Entidades.findByNombre", query = "SELECT e FROM Entidades e WHERE e.nombre = :nombre")})
public class Entidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEntidad")
    private Integer idEntidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacion")
    private int identificacion;
    @Column(name = "digitoVerificacion")
    private Integer digitoVerificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad", fetch = FetchType.EAGER)
    private List<ProcesosDemandantes> procesosDemandantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad", fetch = FetchType.EAGER)
    private List<EntidadesDeudores> entidadesDeudoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad", fetch = FetchType.EAGER)
    private List<Obligaciones> obligacionesList;

    public Entidades() {
    }

    public Entidades(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Entidades(Integer idEntidad, String tipoIdentificacion, int identificacion, String nombre) {
        this.idEntidad = idEntidad;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(Integer digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<ProcesosDemandantes> getProcesosDemandantesList() {
        return procesosDemandantesList;
    }

    public void setProcesosDemandantesList(List<ProcesosDemandantes> procesosDemandantesList) {
        this.procesosDemandantesList = procesosDemandantesList;
    }

    @XmlTransient
    public List<EntidadesDeudores> getEntidadesDeudoresList() {
        return entidadesDeudoresList;
    }

    public void setEntidadesDeudoresList(List<EntidadesDeudores> entidadesDeudoresList) {
        this.entidadesDeudoresList = entidadesDeudoresList;
    }

    @XmlTransient
    public List<Obligaciones> getObligacionesList() {
        return obligacionesList;
    }

    public void setObligacionesList(List<Obligaciones> obligacionesList) {
        this.obligacionesList = obligacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Entidades[ idEntidad=" + idEntidad + " ]";
    }
    
}
