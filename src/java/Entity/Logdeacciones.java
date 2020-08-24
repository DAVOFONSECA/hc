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
@Table(name = "logdeacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logdeacciones.findAll", query = "SELECT l FROM Logdeacciones l")
    , @NamedQuery(name = "Logdeacciones.findByIdConexiones", query = "SELECT l FROM Logdeacciones l WHERE l.idConexiones = :idConexiones")
    , @NamedQuery(name = "Logdeacciones.findByTipo", query = "SELECT l FROM Logdeacciones l WHERE l.tipo = :tipo")
    , @NamedQuery(name = "Logdeacciones.findByFecha", query = "SELECT l FROM Logdeacciones l WHERE l.fecha = :fecha")
    , @NamedQuery(name = "Logdeacciones.findByObservaciones", query = "SELECT l FROM Logdeacciones l WHERE l.observaciones = :observaciones")})
public class Logdeacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConexiones")
    private Integer idConexiones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idUsuario;

    public Logdeacciones() {
    }

    public Logdeacciones(Integer idConexiones) {
        this.idConexiones = idConexiones;
    }

    public Logdeacciones(Integer idConexiones, String tipo, Date fecha) {
        this.idConexiones = idConexiones;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Integer getIdConexiones() {
        return idConexiones;
    }

    public void setIdConexiones(Integer idConexiones) {
        this.idConexiones = idConexiones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConexiones != null ? idConexiones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logdeacciones)) {
            return false;
        }
        Logdeacciones other = (Logdeacciones) object;
        if ((this.idConexiones == null && other.idConexiones != null) || (this.idConexiones != null && !this.idConexiones.equals(other.idConexiones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Logdeacciones[ idConexiones=" + idConexiones + " ]";
    }
    
}
