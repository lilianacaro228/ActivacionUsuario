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
public class IncidenciaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idIncidencia")
    private int idIncidencia;
    @Basic(optional = false)
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @Column(name = "categoria_incidencia")
    private int categoriaIncidencia;

    public IncidenciaPK() {
    }

    public IncidenciaPK(int idIncidencia, int idUser, int categoriaIncidencia) {
        this.idIncidencia = idIncidencia;
        this.idUser = idUser;
        this.categoriaIncidencia = categoriaIncidencia;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getCategoriaIncidencia() {
        return categoriaIncidencia;
    }

    public void setCategoriaIncidencia(int categoriaIncidencia) {
        this.categoriaIncidencia = categoriaIncidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idIncidencia;
        hash += (int) idUser;
        hash += (int) categoriaIncidencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncidenciaPK)) {
            return false;
        }
        IncidenciaPK other = (IncidenciaPK) object;
        if (this.idIncidencia != other.idIncidencia) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.categoriaIncidencia != other.categoriaIncidencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "city.modelo.IncidenciaPK[ idIncidencia=" + idIncidencia + ", idUser=" + idUser + ", categoriaIncidencia=" + categoriaIncidencia + " ]";
    }
    
}
