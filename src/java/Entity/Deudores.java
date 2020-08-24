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
@Table(name = "deudores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deudores.findAll", query = "SELECT d FROM Deudores d")
    , @NamedQuery(name = "Deudores.findByIdDeudor", query = "SELECT d FROM Deudores d WHERE d.idDeudor = :idDeudor")
    , @NamedQuery(name = "Deudores.findByTipoIdentificacion", query = "SELECT d FROM Deudores d WHERE d.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "Deudores.findByIdentificacion", query = "SELECT d FROM Deudores d WHERE d.identificacion = :identificacion")
    , @NamedQuery(name = "Deudores.findByDigitoVerificacion", query = "SELECT d FROM Deudores d WHERE d.digitoVerificacion = :digitoVerificacion")
    , @NamedQuery(name = "Deudores.findByPrimerNombre", query = "SELECT d FROM Deudores d WHERE d.primerNombre = :primerNombre")
    , @NamedQuery(name = "Deudores.findBySegundoNombre", query = "SELECT d FROM Deudores d WHERE d.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Deudores.findByPrimerApellido", query = "SELECT d FROM Deudores d WHERE d.primerApellido = :primerApellido")
    , @NamedQuery(name = "Deudores.findBySegundoApellido", query = "SELECT d FROM Deudores d WHERE d.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Deudores.findByGenero", query = "SELECT d FROM Deudores d WHERE d.genero = :genero")
    , @NamedQuery(name = "Deudores.findByEstado", query = "SELECT d FROM Deudores d WHERE d.estado = :estado")
    , @NamedQuery(name = "Deudores.findByFechaIngreso", query = "SELECT d FROM Deudores d WHERE d.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Deudores.findByPaqueteComercial", query = "SELECT d FROM Deudores d WHERE d.paqueteComercial = :paqueteComercial")})
public class Deudores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDeudor")
    private Integer idDeudor;
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
    @Column(name = "primerNombre")
    private String primerNombre;
    @Size(max = 50)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "paqueteComercial")
    private String paqueteComercial;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeudor", fetch = FetchType.EAGER)
    private List<Solicitudes> solicitudesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeudor", fetch = FetchType.EAGER)
    private List<Telefonos> telefonosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeudor", fetch = FetchType.EAGER)
    private List<EntidadesDeudores> entidadesDeudoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeudor", fetch = FetchType.EAGER)
    private List<ProcesosDemandados> procesosDemandadosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeudor", fetch = FetchType.EAGER)
    private List<Direcciones> direccionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeudor", fetch = FetchType.EAGER)
    private List<DeudoresObligaciones> deudoresObligacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeudor", fetch = FetchType.EAGER)
    private List<Gestionescomerciales> gestionescomercialesList;

    public Deudores() {
    }

    public Deudores(Integer idDeudor) {
        this.idDeudor = idDeudor;
    }

    public Deudores(Integer idDeudor, String tipoIdentificacion, int identificacion, String primerNombre, String primerApellido, String genero, String estado, Date fechaIngreso, String paqueteComercial) {
        this.idDeudor = idDeudor;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.genero = genero;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.paqueteComercial = paqueteComercial;
    }

    public Integer getIdDeudor() {
        return idDeudor;
    }

    public void setIdDeudor(Integer idDeudor) {
        this.idDeudor = idDeudor;
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

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPaqueteComercial() {
        return paqueteComercial;
    }

    public void setPaqueteComercial(String paqueteComercial) {
        this.paqueteComercial = paqueteComercial;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Solicitudes> getSolicitudesList() {
        return solicitudesList;
    }

    public void setSolicitudesList(List<Solicitudes> solicitudesList) {
        this.solicitudesList = solicitudesList;
    }

    @XmlTransient
    public List<Telefonos> getTelefonosList() {
        return telefonosList;
    }

    public void setTelefonosList(List<Telefonos> telefonosList) {
        this.telefonosList = telefonosList;
    }

    @XmlTransient
    public List<EntidadesDeudores> getEntidadesDeudoresList() {
        return entidadesDeudoresList;
    }

    public void setEntidadesDeudoresList(List<EntidadesDeudores> entidadesDeudoresList) {
        this.entidadesDeudoresList = entidadesDeudoresList;
    }

    @XmlTransient
    public List<ProcesosDemandados> getProcesosDemandadosList() {
        return procesosDemandadosList;
    }

    public void setProcesosDemandadosList(List<ProcesosDemandados> procesosDemandadosList) {
        this.procesosDemandadosList = procesosDemandadosList;
    }

    @XmlTransient
    public List<Direcciones> getDireccionesList() {
        return direccionesList;
    }

    public void setDireccionesList(List<Direcciones> direccionesList) {
        this.direccionesList = direccionesList;
    }

    @XmlTransient
    public List<DeudoresObligaciones> getDeudoresObligacionesList() {
        return deudoresObligacionesList;
    }

    public void setDeudoresObligacionesList(List<DeudoresObligaciones> deudoresObligacionesList) {
        this.deudoresObligacionesList = deudoresObligacionesList;
    }

    @XmlTransient
    public List<Gestionescomerciales> getGestionescomercialesList() {
        return gestionescomercialesList;
    }

    public void setGestionescomercialesList(List<Gestionescomerciales> gestionescomercialesList) {
        this.gestionescomercialesList = gestionescomercialesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeudor != null ? idDeudor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deudores)) {
            return false;
        }
        Deudores other = (Deudores) object;
        if ((this.idDeudor == null && other.idDeudor != null) || (this.idDeudor != null && !this.idDeudor.equals(other.idDeudor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Deudores[ idDeudor=" + idDeudor + " ]";
    }
    
}
