/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author esaup
 */
@Entity
@Table(name = "pedidos", catalog = "dam43_BarNorte", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByNumPed", query = "SELECT p FROM Pedidos p WHERE p.numPed = :numPed")
    , @NamedQuery(name = "Pedidos.findByFecha", query = "SELECT p FROM Pedidos p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Pedidos.findByProveedor", query = "SELECT p FROM Pedidos p WHERE p.proveedor = :proveedor")
    , @NamedQuery(name = "Pedidos.findByNombreArt", query = "SELECT p FROM Pedidos p WHERE p.nombreArt = :nombreArt")
    , @NamedQuery(name = "Pedidos.findByCantidad", query = "SELECT p FROM Pedidos p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Pedidos.findByPrecio", query = "SELECT p FROM Pedidos p WHERE p.precio = :precio")
    , @NamedQuery(name = "Pedidos.findByIdBar", query = "SELECT p FROM Pedidos p WHERE p.idBar = :idBar")
    , @NamedQuery(name = "Pedidos.findByCodigoArt", query = "SELECT p FROM Pedidos p WHERE p.codigoArt = :codigoArt")})
public class Pedidos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_ped")
    private Integer numPed;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "proveedor")
    private String proveedor;
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
    @Column(name = "id_bar")
    private int idBar;
    @Basic(optional = false)
    @Column(name = "codigo_art")
    private int codigoArt;

    public Pedidos() {
    }

    public Pedidos(Integer numPed) {
        this.numPed = numPed;
    }

    public Pedidos(Integer numPed, Date fecha, String proveedor, String nombreArt, int cantidad, double precio, int idBar, int codigoArt) {
        this.numPed = numPed;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.nombreArt = nombreArt;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idBar = idBar;
        this.codigoArt = codigoArt;
    }

    public Integer getNumPed() {
        return numPed;
    }

    public void setNumPed(Integer numPed) {
        Integer oldNumPed = this.numPed;
        this.numPed = numPed;
        changeSupport.firePropertyChange("numPed", oldNumPed, numPed);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        String oldProveedor = this.proveedor;
        this.proveedor = proveedor;
        changeSupport.firePropertyChange("proveedor", oldProveedor, proveedor);
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

    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        int oldIdBar = this.idBar;
        this.idBar = idBar;
        changeSupport.firePropertyChange("idBar", oldIdBar, idBar);
    }

    public int getCodigoArt() {
        return codigoArt;
    }

    public void setCodigoArt(int codigoArt) {
        int oldCodigoArt = this.codigoArt;
        this.codigoArt = codigoArt;
        changeSupport.firePropertyChange("codigoArt", oldCodigoArt, codigoArt);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPed != null ? numPed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.numPed == null && other.numPed != null) || (this.numPed != null && !this.numPed.equals(other.numPed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.Pedidos[ numPed=" + numPed + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
