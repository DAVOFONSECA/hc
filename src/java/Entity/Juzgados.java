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
@Table(name = "juzgados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juzgados.findAll", query = "SELECT j FROM Juzgados j")
    , @NamedQuery(name = "Juzgados.findByIdJuzgado", query = "SELECT j FROM Juzgados j WHERE j.idJuzgado = :idJuzgado")
    , @NamedQuery(name = "Juzgados.findByNombre", query = "SELECT j FROM Juzgados j WHERE j.nombre = :nombre")
    , @NamedQuery(name = "Juzgados.findByNumero", query = "SELECT j FROM Juzgados j WHERE j.numero = :numero")
    , @NamedQuery(name = "Juzgados.findByCodigoClase", query = "SELECT j FROM Juzgados j WHERE j.codigoClase = :codigoClase")
    , @NamedQuery(name = "Juzgados.findByDireccion", query = "SELECT j FROM Juzgados j WHERE j.direccion = :direccion")
    , @NamedQuery(name = "Juzgados.findByPiso", query = "SELECT j FROM Juzgados j WHERE j.piso = :piso")
    , @NamedQuery(name = "Juzgados.findByEdificio", query = "SELECT j FROM Juzgados j WHERE j.edificio = :edificio")
    , @NamedQuery(name = "Juzgados.findByDiaRevision", query = "SELECT j FROM Juzgados j WHERE j.diaRevision = :diaRevision")
    , @NamedQuery(name = "Juzgados.findByLugarConsultaRama", query = "SELECT j FROM Juzgados j WHERE j.lugarConsultaRama = :lugarConsultaRama")})
public class Juzgados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idJuzgado")
    private Integer idJuzgado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigoClase")
    private String codigoClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piso")
    private int piso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "edificio")
    private String edificio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diaRevision")
    private int diaRevision;
    @Size(max = 50)
    @Column(name = "lugarConsultaRama")
    private String lugarConsultaRama;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ciudades idCiudad;
    @JoinColumn(name = "idDependiente", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuarios idDependiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJuzgado", fetch = FetchType.EAGER)
    private List<JuzgadosProcesos> juzgadosProcesosList;

    public Juzgados() {
    }

    public Juzgados(Integer idJuzgado) {
        this.idJuzgado = idJuzgado;
    }

    public Juzgados(Integer idJuzgado, String nombre, int numero, String codigoClase, String direccion, int piso, String edificio, int diaRevision) {
        this.idJuzgado = idJuzgado;
        this.nombre = nombre;
        this.numero = numero;
        this.codigoClase = codigoClase;
        this.direccion = direccion;
        this.piso = piso;
        this.edificio = edificio;
        this.diaRevision = diaRevision;
    }

    public Integer getIdJuzgado() {
        return idJuzgado;
    }

    public void setIdJuzgado(Integer idJuzgado) {
        this.idJuzgado = idJuzgado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoClase() {
        return codigoClase;
    }

    public void setCodigoClase(String codigoClase) {
        this.codigoClase = codigoClase;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int getDiaRevision() {
        return diaRevision;
    }

    public void setDiaRevision(int diaRevision) {
        this.diaRevision = diaRevision;
    }

    public String getLugarConsultaRama() {
        return lugarConsultaRama;
    }

    public void setLugarConsultaRama(String lugarConsultaRama) {
        this.lugarConsultaRama = lugarConsultaRama;
    }

    public Ciudades getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudades idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Usuarios getIdDependiente() {
        return idDependiente;
    }

    public void setIdDependiente(Usuarios idDependiente) {
        this.idDependiente = idDependiente;
    }

    @XmlTransient
    public List<JuzgadosProcesos> getJuzgadosProcesosList() {
        return juzgadosProcesosList;
    }

    public void setJuzgadosProcesosList(List<JuzgadosProcesos> juzgadosProcesosList) {
        this.juzgadosProcesosList = juzgadosProcesosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuzgado != null ? idJuzgado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juzgados)) {
            return false;
        }
        Juzgados other = (Juzgados) object;
        if ((this.idJuzgado == null && other.idJuzgado != null) || (this.idJuzgado != null && !this.idJuzgado.equals(other.idJuzgado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Juzgados[ idJuzgado=" + idJuzgado + " ]";
    }
    
}
