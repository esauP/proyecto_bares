/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "bar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bar.findAll", query = "SELECT b FROM Bar b"),
    @NamedQuery(name = "Bar.findByIdBar", query = "SELECT b FROM Bar b WHERE b.idBar = :idBar"),
    @NamedQuery(name = "Bar.findByNombreBar", query = "SELECT b FROM Bar b WHERE b.nombreBar = :nombreBar"),
    @NamedQuery(name = "Bar.findByLicenciaFis", query = "SELECT b FROM Bar b WHERE b.licenciaFis = :licenciaFis"),
    @NamedQuery(name = "Bar.findByDomicilioBar", query = "SELECT b FROM Bar b WHERE b.domicilioBar = :domicilioBar"),
    @NamedQuery(name = "Bar.findByFechaAper", query = "SELECT b FROM Bar b WHERE b.fechaAper = :fechaAper"),
    @NamedQuery(name = "Bar.findByHorario", query = "SELECT b FROM Bar b WHERE b.horario = :horario"),
    @NamedQuery(name = "Bar.findByDiasApertura", query = "SELECT b FROM Bar b WHERE b.diasApertura = :diasApertura")})
public class Bar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bar")
    private Integer idBar;
    @Basic(optional = false)
    @Column(name = "nombre_bar")
    private String nombreBar;
    @Basic(optional = false)
    @Column(name = "licencia_fis")
    private String licenciaFis;
    @Basic(optional = false)
    @Column(name = "domicilio_bar")
    private String domicilioBar;
    @Basic(optional = false)
    @Column(name = "fecha_aper")
    @Temporal(TemporalType.DATE)
    private Date fechaAper;
    @Basic(optional = false)
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @Column(name = "dias_apertura")
    private String diasApertura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barId")
    private Collection<Existencias> existenciasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bar")
    private Collection<Trabaja> trabajaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bar1")
    private Collection<Recaudacion> recaudacionCollection;

    public Bar() {
    }

    public Bar(Integer idBar) {
        this.idBar = idBar;
    }

    public Bar(Integer idBar, String nombreBar, String licenciaFis, String domicilioBar, Date fechaAper, String horario, String diasApertura) {
        this.idBar = idBar;
        this.nombreBar = nombreBar;
        this.licenciaFis = licenciaFis;
        this.domicilioBar = domicilioBar;
        this.fechaAper = fechaAper;
        this.horario = horario;
        this.diasApertura = diasApertura;
    }

    public Integer getIdBar() {
        return idBar;
    }

    public void setIdBar(Integer idBar) {
        this.idBar = idBar;
    }

    public String getNombreBar() {
        return nombreBar;
    }

    public void setNombreBar(String nombreBar) {
        this.nombreBar = nombreBar;
    }

    public String getLicenciaFis() {
        return licenciaFis;
    }

    public void setLicenciaFis(String licenciaFis) {
        this.licenciaFis = licenciaFis;
    }

    public String getDomicilioBar() {
        return domicilioBar;
    }

    public void setDomicilioBar(String domicilioBar) {
        this.domicilioBar = domicilioBar;
    }

    public Date getFechaAper() {
        return fechaAper;
    }

    public void setFechaAper(Date fechaAper) {
        this.fechaAper = fechaAper;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDiasApertura() {
        return diasApertura;
    }

    public void setDiasApertura(String diasApertura) {
        this.diasApertura = diasApertura;
    }

    @XmlTransient
    public Collection<Existencias> getExistenciasCollection() {
        return existenciasCollection;
    }

    public void setExistenciasCollection(Collection<Existencias> existenciasCollection) {
        this.existenciasCollection = existenciasCollection;
    }

    @XmlTransient
    public Collection<Trabaja> getTrabajaCollection() {
        return trabajaCollection;
    }

    public void setTrabajaCollection(Collection<Trabaja> trabajaCollection) {
        this.trabajaCollection = trabajaCollection;
    }

    @XmlTransient
    public Collection<Recaudacion> getRecaudacionCollection() {
        return recaudacionCollection;
    }

    public void setRecaudacionCollection(Collection<Recaudacion> recaudacionCollection) {
        this.recaudacionCollection = recaudacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBar != null ? idBar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bar)) {
            return false;
        }
        Bar other = (Bar) object;
        if ((this.idBar == null && other.idBar != null) || (this.idBar != null && !this.idBar.equals(other.idBar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Bar[ idBar=" + idBar + " ]";
    }
    
}
