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
@Table(name = "procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesos.findAll", query = "SELECT p FROM Procesos p")
    , @NamedQuery(name = "Procesos.findByIdProceso", query = "SELECT p FROM Procesos p WHERE p.idProceso = :idProceso")
    , @NamedQuery(name = "Procesos.findByClaseProceso", query = "SELECT p FROM Procesos p WHERE p.claseProceso = :claseProceso")
    , @NamedQuery(name = "Procesos.findByCuantiaProceso", query = "SELECT p FROM Procesos p WHERE p.cuantiaProceso = :cuantiaProceso")
    , @NamedQuery(name = "Procesos.findByExpedienteCorto", query = "SELECT p FROM Procesos p WHERE p.expedienteCorto = :expedienteCorto")
    , @NamedQuery(name = "Procesos.findByExpedienteLargo", query = "SELECT p FROM Procesos p WHERE p.expedienteLargo = :expedienteLargo")
    , @NamedQuery(name = "Procesos.findByUbicacion", query = "SELECT p FROM Procesos p WHERE p.ubicacion = :ubicacion")
    , @NamedQuery(name = "Procesos.findByEstado", query = "SELECT p FROM Procesos p WHERE p.estado = :estado")
    , @NamedQuery(name = "Procesos.findByPaqueteJuridico", query = "SELECT p FROM Procesos p WHERE p.paqueteJuridico = :paqueteJuridico")})
public class Procesos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProceso")
    private Integer idProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "claseProceso")
    private String claseProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cuantiaProceso")
    private String cuantiaProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "expedienteCorto")
    private String expedienteCorto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 23)
    @Column(name = "expedienteLargo")
    private String expedienteLargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "paqueteJuridico")
    private String paqueteJuridico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<ProcesosDemandantes> procesosDemandantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<Medidas> medidasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<JuzgadosProcesos> juzgadosProcesosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<Gestionesjuridicas> gestionesjuridicasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<ProcesosDemandados> procesosDemandadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProceso", fetch = FetchType.EAGER)
    private List<Notificaciones> notificacionesList;
    @JoinColumn(name = "idGestor", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idGestor;

    public Procesos() {
    }

    public Procesos(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Procesos(Integer idProceso, String claseProceso, String cuantiaProceso, String expedienteCorto, String expedienteLargo, String ubicacion, String estado, String paqueteJuridico) {
        this.idProceso = idProceso;
        this.claseProceso = claseProceso;
        this.cuantiaProceso = cuantiaProceso;
        this.expedienteCorto = expedienteCorto;
        this.expedienteLargo = expedienteLargo;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.paqueteJuridico = paqueteJuridico;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getClaseProceso() {
        return claseProceso;
    }

    public void setClaseProceso(String claseProceso) {
        this.claseProceso = claseProceso;
    }

    public String getCuantiaProceso() {
        return cuantiaProceso;
    }

    public void setCuantiaProceso(String cuantiaProceso) {
        this.cuantiaProceso = cuantiaProceso;
    }

    public String getExpedienteCorto() {
        return expedienteCorto;
    }

    public void setExpedienteCorto(String expedienteCorto) {
        this.expedienteCorto = expedienteCorto;
    }

    public String getExpedienteLargo() {
        return expedienteLargo;
    }

    public void setExpedienteLargo(String expedienteLargo) {
        this.expedienteLargo = expedienteLargo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPaqueteJuridico() {
        return paqueteJuridico;
    }

    public void setPaqueteJuridico(String paqueteJuridico) {
        this.paqueteJuridico = paqueteJuridico;
    }

    @XmlTransient
    public List<ProcesosDemandantes> getProcesosDemandantesList() {
        return procesosDemandantesList;
    }

    public void setProcesosDemandantesList(List<ProcesosDemandantes> procesosDemandantesList) {
        this.procesosDemandantesList = procesosDemandantesList;
    }

    @XmlTransient
    public List<Medidas> getMedidasList() {
        return medidasList;
    }

    public void setMedidasList(List<Medidas> medidasList) {
        this.medidasList = medidasList;
    }

    @XmlTransient
    public List<JuzgadosProcesos> getJuzgadosProcesosList() {
        return juzgadosProcesosList;
    }

    public void setJuzgadosProcesosList(List<JuzgadosProcesos> juzgadosProcesosList) {
        this.juzgadosProcesosList = juzgadosProcesosList;
    }

    @XmlTransient
    public List<Gestionesjuridicas> getGestionesjuridicasList() {
        return gestionesjuridicasList;
    }

    public void setGestionesjuridicasList(List<Gestionesjuridicas> gestionesjuridicasList) {
        this.gestionesjuridicasList = gestionesjuridicasList;
    }

    @XmlTransient
    public List<ProcesosDemandados> getProcesosDemandadosList() {
        return procesosDemandadosList;
    }

    public void setProcesosDemandadosList(List<ProcesosDemandados> procesosDemandadosList) {
        this.procesosDemandadosList = procesosDemandadosList;
    }

    @XmlTransient
    public List<Notificaciones> getNotificacionesList() {
        return notificacionesList;
    }

    public void setNotificacionesList(List<Notificaciones> notificacionesList) {
        this.notificacionesList = notificacionesList;
    }

    public Usuarios getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(Usuarios idGestor) {
        this.idGestor = idGestor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesos)) {
            return false;
        }
        Procesos other = (Procesos) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Procesos[ idProceso=" + idProceso + " ]";
    }
    
}
