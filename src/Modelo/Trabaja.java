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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author esaup
 */
@Entity
@Table(name = "trabaja", catalog = "dam43_BarNorte", schema = "")
@NamedQueries({
    @NamedQuery(name = "Trabaja.findAll", query = "SELECT t FROM Trabaja t")
    , @NamedQuery(name = "Trabaja.findByDniPersona", query = "SELECT t FROM Trabaja t WHERE t.trabajaPK.dniPersona = :dniPersona")
    , @NamedQuery(name = "Trabaja.findByCodigoBar", query = "SELECT t FROM Trabaja t WHERE t.trabajaPK.codigoBar = :codigoBar")
    , @NamedQuery(name = "Trabaja.findByFuncion", query = "SELECT t FROM Trabaja t WHERE t.funcion = :funcion")})
public class Trabaja implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrabajaPK trabajaPK;
    @Basic(optional = false)
    @Column(name = "funcion")
    private String funcion;

    public Trabaja() {
    }

    public Trabaja(TrabajaPK trabajaPK) {
        this.trabajaPK = trabajaPK;
    }

    public Trabaja(TrabajaPK trabajaPK, String funcion) {
        this.trabajaPK = trabajaPK;
        this.funcion = funcion;
    }

    public Trabaja(String dniPersona, int codigoBar) {
        this.trabajaPK = new TrabajaPK(dniPersona, codigoBar);
    }

    public TrabajaPK getTrabajaPK() {
        return trabajaPK;
    }

    public void setTrabajaPK(TrabajaPK trabajaPK) {
        this.trabajaPK = trabajaPK;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        String oldFuncion = this.funcion;
        this.funcion = funcion;
        changeSupport.firePropertyChange("funcion", oldFuncion, funcion);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trabajaPK != null ? trabajaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabaja)) {
            return false;
        }
        Trabaja other = (Trabaja) object;
        if ((this.trabajaPK == null && other.trabajaPK != null) || (this.trabajaPK != null && !this.trabajaPK.equals(other.trabajaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Trabaja[ trabajaPK=" + trabajaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
