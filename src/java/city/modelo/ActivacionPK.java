/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package city.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author personal
 */
@Embeddable
public class ActivacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_Activacion")
    private int idActivacion;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;

    public ActivacionPK() {
    }

    public ActivacionPK(int idActivacion, int userId) {
        this.idActivacion = idActivacion;
        this.userId = userId;
    }

    public int getIdActivacion() {
        return idActivacion;
    }

    public void setIdActivacion(int idActivacion) {
        this.idActivacion = idActivacion;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActivacion;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivacionPK)) {
            return false;
        }
        ActivacionPK other = (ActivacionPK) object;
        if (this.idActivacion != other.idActivacion) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "city.modelo.ActivacionPK[ idActivacion=" + idActivacion + ", userId=" + userId + " ]";
    }
    
}
