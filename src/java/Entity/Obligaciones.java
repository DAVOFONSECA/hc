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
@Table(name = "obligaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obligaciones.findAll", query = "SELECT o FROM Obligaciones o")
    , @NamedQuery(name = "Obligaciones.findByIdObligacion", query = "SELECT o FROM Obligaciones o WHERE o.idObligacion = :idObligacion")
    , @NamedQuery(name = "Obligaciones.findByNumero", query = "SELECT o FROM Obligaciones o WHERE o.numero = :numero")
    , @NamedQuery(name = "Obligaciones.findByTipo", query = "SELECT o FROM Obligaciones o WHERE o.tipo = :tipo")
    , @NamedQuery(name = "Obligaciones.findBySubTipo", query = "SELECT o FROM Obligaciones o WHERE o.subTipo = :subTipo")
    , @NamedQuery(name = "Obligaciones.findBySaldoTotal", query = "SELECT o FROM Obligaciones o WHERE o.saldoTotal = :saldoTotal")
    , @NamedQuery(name = "Obligaciones.findBySaldoCapital", query = "SELECT o FROM Obligaciones o WHERE o.saldoCapital = :saldoCapital")
    , @NamedQuery(name = "Obligaciones.findByDiasMora", query = "SELECT o FROM Obligaciones o WHERE o.diasMora = :diasMora")
    , @NamedQuery(name = "Obligaciones.findByDiaCaida", query = "SELECT o FROM Obligaciones o WHERE o.diaCaida = :diaCaida")
    , @NamedQuery(name = "Obligaciones.findByFechaUltimaActualizacion", query = "SELECT o FROM Obligaciones o WHERE o.fechaUltimaActualizacion = :fechaUltimaActualizacion")
    , @NamedQuery(name = "Obligaciones.findByFechaCastigo", query = "SELECT o FROM Obligaciones o WHERE o.fechaCastigo = :fechaCastigo")
    , @NamedQuery(name = "Obligaciones.findByMeta", query = "SELECT o FROM Obligaciones o WHERE o.meta = :meta")
    , @NamedQuery(name = "Obligaciones.findByEstado", query = "SELECT o FROM Obligaciones o WHERE o.estado = :estado")})
public class Obligaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idObligacion")
    private Integer idObligacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subTipo")
    private String subTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoTotal")
    private double saldoTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoCapital")
    private double saldoCapital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diasMora")
    private int diasMora;
    @Column(name = "diaCaida")
    private Integer diaCaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaUltimaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaActualizacion;
    @Column(name = "fechaCastigo")
    @Temporal(TemporalType.DATE)
    private Date fechaCastigo;
    @Size(max = 30)
    @Column(name = "meta")
    private String meta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.EAGER)
    private List<Acuerdos> acuerdosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.EAGER)
    private List<ObligacionesGarantias> obligacionesGarantiasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObligacion", fetch = FetchType.EAGER)
    private List<DeudoresObligaciones> deudoresObligacionesList;
    @JoinColumn(name = "idEntidad", referencedColumnName = "idEntidad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Entidades idEntidad;

    public Obligaciones() {
    }

    public Obligaciones(Integer idObligacion) {
        this.idObligacion = idObligacion;
    }

    public Obligaciones(Integer idObligacion, String numero, String tipo, String subTipo, double saldoTotal, double saldoCapital, int diasMora, Date fechaUltimaActualizacion, String estado) {
        this.idObligacion = idObligacion;
        this.numero = numero;
        this.tipo = tipo;
        this.subTipo = subTipo;
        this.saldoTotal = saldoTotal;
        this.saldoCapital = saldoCapital;
        this.diasMora = diasMora;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.estado = estado;
    }

    public Integer getIdObligacion() {
        return idObligacion;
    }

    public void setIdObligacion(Integer idObligacion) {
        this.idObligacion = idObligacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public double getSaldoCapital() {
        return saldoCapital;
    }

    public void setSaldoCapital(double saldoCapital) {
        this.saldoCapital = saldoCapital;
    }

    public int getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(int diasMora) {
        this.diasMora = diasMora;
    }

    public Integer getDiaCaida() {
        return diaCaida;
    }

    public void setDiaCaida(Integer diaCaida) {
        this.diaCaida = diaCaida;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Date getFechaCastigo() {
        return fechaCastigo;
    }

    public void setFechaCastigo(Date fechaCastigo) {
        this.fechaCastigo = fechaCastigo;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Acuerdos> getAcuerdosList() {
        return acuerdosList;
    }

    public void setAcuerdosList(List<Acuerdos> acuerdosList) {
        this.acuerdosList = acuerdosList;
    }

    @XmlTransient
    public List<ObligacionesGarantias> getObligacionesGarantiasList() {
        return obligacionesGarantiasList;
    }

    public void setObligacionesGarantiasList(List<ObligacionesGarantias> obligacionesGarantiasList) {
        this.obligacionesGarantiasList = obligacionesGarantiasList;
    }

    @XmlTransient
    public List<DeudoresObligaciones> getDeudoresObligacionesList() {
        return deudoresObligacionesList;
    }

    public void setDeudoresObligacionesList(List<DeudoresObligaciones> deudoresObligacionesList) {
        this.deudoresObligacionesList = deudoresObligacionesList;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObligacion != null ? idObligacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obligaciones)) {
            return false;
        }
        Obligaciones other = (Obligaciones) object;
        if ((this.idObligacion == null && other.idObligacion != null) || (this.idObligacion != null && !this.idObligacion.equals(other.idObligacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Obligaciones[ idObligacion=" + idObligacion + " ]";
    }
    
}
