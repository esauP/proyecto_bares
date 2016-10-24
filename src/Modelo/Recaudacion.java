
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "recaudacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recaudacion.findAll", query = "SELECT r FROM Recaudacion r"),
    @NamedQuery(name = "Recaudacion.findByBar", query = "SELECT r FROM Recaudacion r WHERE r.recaudacionPK.bar = :bar"),
    @NamedQuery(name = "Recaudacion.findByFecha", query = "SELECT r FROM Recaudacion r WHERE r.recaudacionPK.fecha = :fecha"),
    @NamedQuery(name = "Recaudacion.findByRectotal", query = "SELECT r FROM Recaudacion r WHERE r.rectotal = :rectotal")})
public class Recaudacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecaudacionPK recaudacionPK;
    @Basic(optional = false)
    @Column(name = "rectotal")
    private double rectotal;
    @JoinColumn(name = "bar", referencedColumnName = "id_bar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bar bar1;

    public Recaudacion() {
    }

    public Recaudacion(RecaudacionPK recaudacionPK) {
        this.recaudacionPK = recaudacionPK;
    }

    public Recaudacion(RecaudacionPK recaudacionPK, double rectotal) {
        this.recaudacionPK = recaudacionPK;
        this.rectotal = rectotal;
    }

    public Recaudacion(int bar, Date fecha) {
        this.recaudacionPK = new RecaudacionPK(bar, fecha);
    }

    public RecaudacionPK getRecaudacionPK() {
        return recaudacionPK;
    }

    public void setRecaudacionPK(RecaudacionPK recaudacionPK) {
        this.recaudacionPK = recaudacionPK;
    }

    public double getRectotal() {
        return rectotal;
    }

    public void setRectotal(double rectotal) {
        this.rectotal = rectotal;
    }

    public Bar getBar1() {
        return bar1;
    }

    public void setBar1(Bar bar1) {
        this.bar1 = bar1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recaudacionPK != null ? recaudacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recaudacion)) {
            return false;
        }
        Recaudacion other = (Recaudacion) object;
        if ((this.recaudacionPK == null && other.recaudacionPK != null) || (this.recaudacionPK != null && !this.recaudacionPK.equals(other.recaudacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Recaudacion[ recaudacionPK=" + recaudacionPK + " ]";
    }
    
}
