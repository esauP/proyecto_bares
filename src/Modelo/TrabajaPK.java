/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author esaup
 */
@Embeddable
public class TrabajaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "dni_persona")
    private String dniPersona;
    @Basic(optional = false)
    @Column(name = "codigo_bar")
    private int codigoBar;

    public TrabajaPK() {
    }

    public TrabajaPK(String dniPersona, int codigoBar) {
        this.dniPersona = dniPersona;
        this.codigoBar = codigoBar;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public int getCodigoBar() {
        return codigoBar;
    }

    public void setCodigoBar(int codigoBar) {
        this.codigoBar = codigoBar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniPersona != null ? dniPersona.hashCode() : 0);
        hash += (int) codigoBar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajaPK)) {
            return false;
        }
        TrabajaPK other = (TrabajaPK) object;
        if ((this.dniPersona == null && other.dniPersona != null) || (this.dniPersona != null && !this.dniPersona.equals(other.dniPersona))) {
            return false;
        }
        if (this.codigoBar != other.codigoBar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vista.TrabajaPK[ dniPersona=" + dniPersona + ", codigoBar=" + codigoBar + " ]";
    }
    
}
