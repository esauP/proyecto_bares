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
@Table(name = "empleados", catalog = "dam43_BarNorte", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByIdEmp", query = "SELECT e FROM Empleados e WHERE e.idEmp = :idEmp")
    , @NamedQuery(name = "Empleados.findByNombreEmp", query = "SELECT e FROM Empleados e WHERE e.nombreEmp = :nombreEmp")
    , @NamedQuery(name = "Empleados.findByDniEmp", query = "SELECT e FROM Empleados e WHERE e.dniEmp = :dniEmp")
    , @NamedQuery(name = "Empleados.findByDomicilioEmp", query = "SELECT e FROM Empleados e WHERE e.domicilioEmp = :domicilioEmp")})
public class Empleados implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emp")
    private Integer idEmp;
    @Basic(optional = false)
    @Column(name = "nombre_emp")
    private String nombreEmp;
    @Basic(optional = false)
    @Column(name = "dni_emp")
    private String dniEmp;
    @Basic(optional = false)
    @Column(name = "domicilio_emp")
    private String domicilioEmp;

    public Empleados() {
    }

    public Empleados(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Empleados(Integer idEmp, String nombreEmp, String dniEmp, String domicilioEmp) {
        this.idEmp = idEmp;
        this.nombreEmp = nombreEmp;
        this.dniEmp = dniEmp;
        this.domicilioEmp = domicilioEmp;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        Integer oldIdEmp = this.idEmp;
        this.idEmp = idEmp;
        changeSupport.firePropertyChange("idEmp", oldIdEmp, idEmp);
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        String oldNombreEmp = this.nombreEmp;
        this.nombreEmp = nombreEmp;
        changeSupport.firePropertyChange("nombreEmp", oldNombreEmp, nombreEmp);
    }

    public String getDniEmp() {
        return dniEmp;
    }

    public void setDniEmp(String dniEmp) {
        String oldDniEmp = this.dniEmp;
        this.dniEmp = dniEmp;
        changeSupport.firePropertyChange("dniEmp", oldDniEmp, dniEmp);
    }

    public String getDomicilioEmp() {
        return domicilioEmp;
    }

    public void setDomicilioEmp(String domicilioEmp) {
        String oldDomicilioEmp = this.domicilioEmp;
        this.domicilioEmp = domicilioEmp;
        changeSupport.firePropertyChange("domicilioEmp", oldDomicilioEmp, domicilioEmp);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmp != null ? idEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmp == null && other.idEmp != null) || (this.idEmp != null && !this.idEmp.equals(other.idEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Empleados[ idEmp=" + idEmp + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
