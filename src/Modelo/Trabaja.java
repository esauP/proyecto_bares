
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "trabaja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabaja.findAll", query = "SELECT t FROM Trabaja t"),
    @NamedQuery(name = "Trabaja.findByDniPersona", query = "SELECT t FROM Trabaja t WHERE t.trabajaPK.dniPersona = :dniPersona"),
    @NamedQuery(name = "Trabaja.findByCodigoBar", query = "SELECT t FROM Trabaja t WHERE t.trabajaPK.codigoBar = :codigoBar"),
    @NamedQuery(name = "Trabaja.findByFuncion", query = "SELECT t FROM Trabaja t WHERE t.funcion = :funcion")})
public class Trabaja implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrabajaPK trabajaPK;
    @Basic(optional = false)
    @Column(name = "funcion")
    private String funcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "trabaja")
    private Persona persona;
    @JoinColumn(name = "codigo_bar", referencedColumnName = "id_bar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bar bar;

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
        this.funcion = funcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
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
        return "Modelo.Trabaja[ trabajaPK=" + trabajaPK + " ]";
    }
    
}
