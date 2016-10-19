/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author esaup
 */
@Entity
@Table(name = "titular", catalog = "dam43_BarNorte", schema = "")
@NamedQueries({
    @NamedQuery(name = "Titular.findAll", query = "SELECT t FROM Titular t")
    , @NamedQuery(name = "Titular.findByIdTit", query = "SELECT t FROM Titular t WHERE t.idTit = :idTit")
    , @NamedQuery(name = "Titular.findByNombreTit", query = "SELECT t FROM Titular t WHERE t.nombreTit = :nombreTit")
    , @NamedQuery(name = "Titular.findByDni", query = "SELECT t FROM Titular t WHERE t.dni = :dni")
    , @NamedQuery(name = "Titular.findByDomicilioTit", query = "SELECT t FROM Titular t WHERE t.domicilioTit = :domicilioTit")})
public class Titular implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tit")
    private Integer idTit;
    @Basic(optional = false)
    @Column(name = "nombre_tit")
    private String nombreTit;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "domicilio_tit")
    private String domicilioTit;

    public Titular() {
    }

    public Titular(Integer idTit) {
        this.idTit = idTit;
    }

    public Titular(Integer idTit, String nombreTit, String dni, String domicilioTit) {
        this.idTit = idTit;
        this.nombreTit = nombreTit;
        this.dni = dni;
        this.domicilioTit = domicilioTit;
    }

    public Integer getIdTit() {
        return idTit;
    }

    public void setIdTit(Integer idTit) {
        Integer oldIdTit = this.idTit;
        this.idTit = idTit;
        changeSupport.firePropertyChange("idTit", oldIdTit, idTit);
    }

    public String getNombreTit() {
        return nombreTit;
    }

    public void setNombreTit(String nombreTit) {
        String oldNombreTit = this.nombreTit;
        this.nombreTit = nombreTit;
        changeSupport.firePropertyChange("nombreTit", oldNombreTit, nombreTit);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        String oldDni = this.dni;
        this.dni = dni;
        changeSupport.firePropertyChange("dni", oldDni, dni);
    }

    public String getDomicilioTit() {
        return domicilioTit;
    }

    public void setDomicilioTit(String domicilioTit) {
        String oldDomicilioTit = this.domicilioTit;
        this.domicilioTit = domicilioTit;
        changeSupport.firePropertyChange("domicilioTit", oldDomicilioTit, domicilioTit);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTit != null ? idTit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titular)) {
            return false;
        }
        Titular other = (Titular) object;
        if ((this.idTit == null && other.idTit != null) || (this.idTit != null && !this.idTit.equals(other.idTit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Titular[ idTit=" + idTit + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
