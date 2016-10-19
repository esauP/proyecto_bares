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
@Table(name = "existencias", catalog = "dam43_BarNorte", schema = "")
@NamedQueries({
    @NamedQuery(name = "Existencias.findAll", query = "SELECT e FROM Existencias e")
    , @NamedQuery(name = "Existencias.findByIdArt", query = "SELECT e FROM Existencias e WHERE e.idArt = :idArt")
    , @NamedQuery(name = "Existencias.findByNombreArt", query = "SELECT e FROM Existencias e WHERE e.nombreArt = :nombreArt")
    , @NamedQuery(name = "Existencias.findByCantidad", query = "SELECT e FROM Existencias e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "Existencias.findByPrecio", query = "SELECT e FROM Existencias e WHERE e.precio = :precio")
    , @NamedQuery(name = "Existencias.findByBarId", query = "SELECT e FROM Existencias e WHERE e.barId = :barId")})
public class Existencias implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_art")
    private Integer idArt;
    @Basic(optional = false)
    @Column(name = "nombre_art")
    private String nombreArt;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @Column(name = "bar_id")
    private int barId;

    public Existencias() {
    }

    public Existencias(Integer idArt) {
        this.idArt = idArt;
    }

    public Existencias(Integer idArt, String nombreArt, int cantidad, double precio, int barId) {
        this.idArt = idArt;
        this.nombreArt = nombreArt;
        this.cantidad = cantidad;
        this.precio = precio;
        this.barId = barId;
    }

    public Integer getIdArt() {
        return idArt;
    }

    public void setIdArt(Integer idArt) {
        Integer oldIdArt = this.idArt;
        this.idArt = idArt;
        changeSupport.firePropertyChange("idArt", oldIdArt, idArt);
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        String oldNombreArt = this.nombreArt;
        this.nombreArt = nombreArt;
        changeSupport.firePropertyChange("nombreArt", oldNombreArt, nombreArt);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        int oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        changeSupport.firePropertyChange("cantidad", oldCantidad, cantidad);
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        double oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
    }

    public int getBarId() {
        return barId;
    }

    public void setBarId(int barId) {
        int oldBarId = this.barId;
        this.barId = barId;
        changeSupport.firePropertyChange("barId", oldBarId, barId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArt != null ? idArt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Existencias)) {
            return false;
        }
        Existencias other = (Existencias) object;
        if ((this.idArt == null && other.idArt != null) || (this.idArt != null && !this.idArt.equals(other.idArt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Existencias[ idArt=" + idArt + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
