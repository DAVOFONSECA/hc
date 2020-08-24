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
@Table(name = "cuotasacuerdos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuotasacuerdos.findAll", query = "SELECT c FROM Cuotasacuerdos c")
    , @NamedQuery(name = "Cuotasacuerdos.findByIdCuotaAcuerdo", query = "SELECT c FROM Cuotasacuerdos c WHERE c.idCuotaAcuerdo = :idCuotaAcuerdo")
    , @NamedQuery(name = "Cuotasacuerdos.findByNumeroCuota", query = "SELECT c FROM Cuotasacuerdos c WHERE c.numeroCuota = :numeroCuota")
    , @NamedQuery(name = "Cuotasacuerdos.findByFechaCuota", query = "SELECT c FROM Cuotasacuerdos c WHERE c.fechaCuota = :fechaCuota")
    , @NamedQuery(name = "Cuotasacuerdos.findByValorCuota", query = "SELECT c FROM Cuotasacuerdos c WHERE c.valorCuota = :valorCuota")
    , @NamedQuery(name = "Cuotasacuerdos.findByEstado", query = "SELECT c FROM Cuotasacuerdos c WHERE c.estado = :estado")})
public class Cuotasacuerdos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCuotaAcuerdo")
    private Integer idCuotaAcuerdo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroCuota")
    private int numeroCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCuota")
    @Temporal(TemporalType.DATE)
    private Date fechaCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorCuota")
    private double valorCuota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idAcuerdo", referencedColumnName = "idAcuerdo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Acuerdos idAcuerdo;

    public Cuotasacuerdos() {
    }

    public Cuotasacuerdos(Integer idCuotaAcuerdo) {
        this.idCuotaAcuerdo = idCuotaAcuerdo;
    }

    public Cuotasacuerdos(Integer idCuotaAcuerdo, int numeroCuota, Date fechaCuota, double valorCuota, String estado) {
        this.idCuotaAcuerdo = idCuotaAcuerdo;
        this.numeroCuota = numeroCuota;
        this.fechaCuota = fechaCuota;
        this.valorCuota = valorCuota;
        this.estado = estado;
    }

    public Integer getIdCuotaAcuerdo() {
        return idCuotaAcuerdo;
    }

    public void setIdCuotaAcuerdo(Integer idCuotaAcuerdo) {
        this.idCuotaAcuerdo = idCuotaAcuerdo;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Date getFechaCuota() {
        return fechaCuota;
    }

    public void setFechaCuota(Date fechaCuota) {
        this.fechaCuota = fechaCuota;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Acuerdos getIdAcuerdo() {
        return idAcuerdo;
    }

    public void setIdAcuerdo(Acuerdos idAcuerdo) {
        this.idAcuerdo = idAcuerdo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuotaAcuerdo != null ? idCuotaAcuerdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuotasacuerdos)) {
            return false;
        }
        Cuotasacuerdos other = (Cuotasacuerdos) object;
        if ((this.idCuotaAcuerdo == null && other.idCuotaAcuerdo != null) || (this.idCuotaAcuerdo != null && !this.idCuotaAcuerdo.equals(other.idCuotaAcuerdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cuotasacuerdos[ idCuotaAcuerdo=" + idCuotaAcuerdo + " ]";
    }
    
}
