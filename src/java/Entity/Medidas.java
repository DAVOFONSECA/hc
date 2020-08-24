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
@Table(name = "medidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medidas.findAll", query = "SELECT m FROM Medidas m")
    , @NamedQuery(name = "Medidas.findByIdMedida", query = "SELECT m FROM Medidas m WHERE m.idMedida = :idMedida")
    , @NamedQuery(name = "Medidas.findByParticipacion", query = "SELECT m FROM Medidas m WHERE m.participacion = :participacion")
    , @NamedQuery(name = "Medidas.findByTipo", query = "SELECT m FROM Medidas m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Medidas.findByTipoIdentificacion", query = "SELECT m FROM Medidas m WHERE m.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Medidas.findByNumeroIdentificacion", query = "SELECT m FROM Medidas m WHERE m.numeroIdentificacion = :numeroIdentificacion")
    , @NamedQuery(name = "Medidas.findByEntidadODestinatario", query = "SELECT m FROM Medidas m WHERE m.entidadODestinatario = :entidadODestinatario")
    , @NamedQuery(name = "Medidas.findByDireccionDestinatario", query = "SELECT m FROM Medidas m WHERE m.direccionDestinatario = :direccionDestinatario")
    , @NamedQuery(name = "Medidas.findByEncargado", query = "SELECT m FROM Medidas m WHERE m.encargado = :encargado")
    , @NamedQuery(name = "Medidas.findByObservacion", query = "SELECT m FROM Medidas m WHERE m.observacion = :observacion")
    , @NamedQuery(name = "Medidas.findByEstado", query = "SELECT m FROM Medidas m WHERE m.estado = :estado")})
public class Medidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedida")
    private Integer idMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "participacion")
    private String participacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipoIdentificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numeroIdentificacion")
    private String numeroIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "entidadODestinatario")
    private String entidadODestinatario;
    @Size(max = 100)
    @Column(name = "direccionDestinatario")
    private String direccionDestinatario;
    @Size(max = 50)
    @Column(name = "encargado")
    private String encargado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idProceso", referencedColumnName = "idProceso")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Procesos idProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedidas", fetch = FetchType.EAGER)
    private List<Actuacionesmedidas> actuacionesmedidasList;

    public Medidas() {
    }

    public Medidas(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public Medidas(Integer idMedida, String participacion, String tipo, String tipoIdentificacion, String numeroIdentificacion, String entidadODestinatario, String observacion, String estado) {
        this.idMedida = idMedida;
        this.participacion = participacion;
        this.tipo = tipo;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.entidadODestinatario = entidadODestinatario;
        this.observacion = observacion;
        this.estado = estado;
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public String getParticipacion() {
        return participacion;
    }

    public void setParticipacion(String participacion) {
        this.participacion = participacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getEntidadODestinatario() {
        return entidadODestinatario;
    }

    public void setEntidadODestinatario(String entidadODestinatario) {
        this.entidadODestinatario = entidadODestinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Procesos getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Procesos idProceso) {
        this.idProceso = idProceso;
    }

    @XmlTransient
    public List<Actuacionesmedidas> getActuacionesmedidasList() {
        return actuacionesmedidasList;
    }

    public void setActuacionesmedidasList(List<Actuacionesmedidas> actuacionesmedidasList) {
        this.actuacionesmedidasList = actuacionesmedidasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedida != null ? idMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medidas)) {
            return false;
        }
        Medidas other = (Medidas) object;
        if ((this.idMedida == null && other.idMedida != null) || (this.idMedida != null && !this.idMedida.equals(other.idMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Medidas[ idMedida=" + idMedida + " ]";
    }
    
}
