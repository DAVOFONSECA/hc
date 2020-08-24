/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "telefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonos.findAll", query = "SELECT t FROM Telefonos t")
    , @NamedQuery(name = "Telefonos.findByIdTelefono", query = "SELECT t FROM Telefonos t WHERE t.idTelefono = :idTelefono")
    , @NamedQuery(name = "Telefonos.findByTipo", query = "SELECT t FROM Telefonos t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "Telefonos.findByCodigoArea", query = "SELECT t FROM Telefonos t WHERE t.codigoArea = :codigoArea")
    , @NamedQuery(name = "Telefonos.findByTelefono", query = "SELECT t FROM Telefonos t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Telefonos.findByExtension", query = "SELECT t FROM Telefonos t WHERE t.extension = :extension")
    , @NamedQuery(name = "Telefonos.findByLugar", query = "SELECT t FROM Telefonos t WHERE t.lugar = :lugar")
    , @NamedQuery(name = "Telefonos.findByIntentos", query = "SELECT t FROM Telefonos t WHERE t.intentos = :intentos")
    , @NamedQuery(name = "Telefonos.findByIntentosEfectivos", query = "SELECT t FROM Telefonos t WHERE t.intentosEfectivos = :intentosEfectivos")
    , @NamedQuery(name = "Telefonos.findByFechaUltimaActualizacion", query = "SELECT t FROM Telefonos t WHERE t.fechaUltimaActualizacion = :fechaUltimaActualizacion")
    , @NamedQuery(name = "Telefonos.findByEstado", query = "SELECT t FROM Telefonos t WHERE t.estado = :estado")})
public class Telefonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefono")
    private Integer idTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "codigoArea")
    private Integer codigoArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "extension")
    private Integer extension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "intentos")
    private Integer intentos;
    @Column(name = "intentosEfectivos")
    private Integer intentosEfectivos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaUltimaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idDeudor", referencedColumnName = "idDeudor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Deudores idDeudor;

    public Telefonos() {
    }

    public Telefonos(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Telefonos(Integer idTelefono, String tipo, String telefono, String lugar, Date fechaUltimaActualizacion, String estado) {
        this.idTelefono = idTelefono;
        this.tipo = tipo;
        this.telefono = telefono;
        this.lugar = lugar;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.estado = estado;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(Integer codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getIntentos() {
        return intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public Integer getIntentosEfectivos() {
        return intentosEfectivos;
    }

    public void setIntentosEfectivos(Integer intentosEfectivos) {
        this.intentosEfectivos = intentosEfectivos;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Deudores getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(Deudores idDeudor) {
        this.idDeudor = idDeudor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonos)) {
            return false;
        }
        Telefonos other = (Telefonos) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Telefonos[ idTelefono=" + idTelefono + " ]";
    }
    
}
