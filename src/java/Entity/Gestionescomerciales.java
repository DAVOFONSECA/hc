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
@Table(name = "gestionescomerciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestionescomerciales.findAll", query = "SELECT g FROM Gestionescomerciales g")
    , @NamedQuery(name = "Gestionescomerciales.findByIdGestion", query = "SELECT g FROM Gestionescomerciales g WHERE g.idGestion = :idGestion")
    , @NamedQuery(name = "Gestionescomerciales.findByFechaGestion", query = "SELECT g FROM Gestionescomerciales g WHERE g.fechaGestion = :fechaGestion")
    , @NamedQuery(name = "Gestionescomerciales.findByGestion", query = "SELECT g FROM Gestionescomerciales g WHERE g.gestion = :gestion")
    , @NamedQuery(name = "Gestionescomerciales.findByDato", query = "SELECT g FROM Gestionescomerciales g WHERE g.dato = :dato")
    , @NamedQuery(name = "Gestionescomerciales.findByContacto", query = "SELECT g FROM Gestionescomerciales g WHERE g.contacto = :contacto")
    , @NamedQuery(name = "Gestionescomerciales.findByResultado", query = "SELECT g FROM Gestionescomerciales g WHERE g.resultado = :resultado")
    , @NamedQuery(name = "Gestionescomerciales.findByCausaMora", query = "SELECT g FROM Gestionescomerciales g WHERE g.causaMora = :causaMora")
    , @NamedQuery(name = "Gestionescomerciales.findByObservacion", query = "SELECT g FROM Gestionescomerciales g WHERE g.observacion = :observacion")
    , @NamedQuery(name = "Gestionescomerciales.findByAdjunto", query = "SELECT g FROM Gestionescomerciales g WHERE g.adjunto = :adjunto")})
public class Gestionescomerciales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGestion")
    private Integer idGestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaGestion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "gestion")
    private String gestion;
    @Size(max = 100)
    @Column(name = "dato")
    private String dato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "resultado")
    private String resultado;
    @Size(max = 50)
    @Column(name = "causaMora")
    private String causaMora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 100)
    @Column(name = "adjunto")
    private String adjunto;
    @JoinColumn(name = "idDeudor", referencedColumnName = "idDeudor")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Deudores idDeudor;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idUsuario;

    public Gestionescomerciales() {
    }

    public Gestionescomerciales(Integer idGestion) {
        this.idGestion = idGestion;
    }

    public Gestionescomerciales(Integer idGestion, Date fechaGestion, String gestion, String contacto, String resultado, String observacion) {
        this.idGestion = idGestion;
        this.fechaGestion = fechaGestion;
        this.gestion = gestion;
        this.contacto = contacto;
        this.resultado = resultado;
        this.observacion = observacion;
    }

    public Integer getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(Integer idGestion) {
        this.idGestion = idGestion;
    }

    public Date getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getCausaMora() {
        return causaMora;
    }

    public void setCausaMora(String causaMora) {
        this.causaMora = causaMora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public Deudores getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(Deudores idDeudor) {
        this.idDeudor = idDeudor;
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
        hash += (idGestion != null ? idGestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestionescomerciales)) {
            return false;
        }
        Gestionescomerciales other = (Gestionescomerciales) object;
        if ((this.idGestion == null && other.idGestion != null) || (this.idGestion != null && !this.idGestion.equals(other.idGestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Gestionescomerciales[ idGestion=" + idGestion + " ]";
    }
    
}
