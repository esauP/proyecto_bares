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
@Table(name = "persona", catalog = "dam43_BarNorte", schema = "")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByNombrePers", query = "SELECT p FROM Persona p WHERE p.nombrePers = :nombrePers")
    , @NamedQuery(name = "Persona.findByDomicilioPer", query = "SELECT p FROM Persona p WHERE p.domicilioPer = :domicilioPer")
    , @NamedQuery(name = "Persona.findByDniPer", query = "SELECT p FROM Persona p WHERE p.dniPer = :dniPer")
    , @NamedQuery(name = "Persona.findByFuncion", query = "SELECT p FROM Persona p WHERE p.funcion = :funcion")
    , @NamedQuery(name = "Persona.findByTitular", query = "SELECT p FROM Persona p WHERE p.titular = :titular")})
public class Persona implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nombre_pers")
    private String nombrePers;
    @Basic(optional = false)
    @Column(name = "domicilio_per")
    private String domicilioPer;
    @Id
    @Basic(optional = false)
    @Column(name = "dni_per")
    private String dniPer;
    @Basic(optional = false)
    @Column(name = "funcion")
    private String funcion;
    @Basic(optional = false)
    @Column(name = "titular")
    private boolean titular;

    public Persona() {
    }

    public Persona(String dniPer) {
        this.dniPer = dniPer;
    }

    public Persona(String dniPer, String nombrePers, String domicilioPer, String funcion, boolean titular) {
        this.dniPer = dniPer;
        this.nombrePers = nombrePers;
        this.domicilioPer = domicilioPer;
        this.funcion = funcion;
        this.titular = titular;
    }

    public String getNombrePers() {
        return nombrePers;
    }

    public void setNombrePers(String nombrePers) {
        String oldNombrePers = this.nombrePers;
        this.nombrePers = nombrePers;
        changeSupport.firePropertyChange("nombrePers", oldNombrePers, nombrePers);
    }

    public String getDomicilioPer() {
        return domicilioPer;
    }

    public void setDomicilioPer(String domicilioPer) {
        String oldDomicilioPer = this.domicilioPer;
        this.domicilioPer = domicilioPer;
        changeSupport.firePropertyChange("domicilioPer", oldDomicilioPer, domicilioPer);
    }

    public String getDniPer() {
        return dniPer;
    }

    public void setDniPer(String dniPer) {
        String oldDniPer = this.dniPer;
        this.dniPer = dniPer;
        changeSupport.firePropertyChange("dniPer", oldDniPer, dniPer);
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        String oldFuncion = this.funcion;
        this.funcion = funcion;
        changeSupport.firePropertyChange("funcion", oldFuncion, funcion);
    }

    public boolean getTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        boolean oldTitular = this.titular;
        this.titular = titular;
        changeSupport.firePropertyChange("titular", oldTitular, titular);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniPer != null ? dniPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.dniPer == null && other.dniPer != null) || (this.dniPer != null && !this.dniPer.equals(other.dniPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Persona[ dniPer=" + dniPer + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
