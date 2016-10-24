
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "existencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Existencias.findAll", query = "SELECT e FROM Existencias e"),
    @NamedQuery(name = "Existencias.findByIdArt", query = "SELECT e FROM Existencias e WHERE e.idArt = :idArt"),
    @NamedQuery(name = "Existencias.findByNombreArt", query = "SELECT e FROM Existencias e WHERE e.nombreArt = :nombreArt"),
    @NamedQuery(name = "Existencias.findByCantidad", query = "SELECT e FROM Existencias e WHERE e.cantidad = :cantidad"),
    @NamedQuery(name = "Existencias.findByPrecio", query = "SELECT e FROM Existencias e WHERE e.precio = :precio")})
public class Existencias implements Serializable {

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
    @JoinColumn(name = "bar_id", referencedColumnName = "id_bar")
    @ManyToOne(optional = false)
    private Bar barId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoArt")
    private Collection<Pedidos> pedidosCollection;

    public Existencias() {
    }

    public Existencias(Integer idArt) {
        this.idArt = idArt;
    }

    public Existencias(Integer idArt, String nombreArt, int cantidad, double precio) {
        this.idArt = idArt;
        this.nombreArt = nombreArt;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIdArt() {
        return idArt;
    }

    public void setIdArt(Integer idArt) {
        this.idArt = idArt;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Bar getBarId() {
        return barId;
    }

    public void setBarId(Bar barId) {
        this.barId = barId;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
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
        return "Modelo.Existencias[ idArt=" + idArt + " ]";
    }
    
}
