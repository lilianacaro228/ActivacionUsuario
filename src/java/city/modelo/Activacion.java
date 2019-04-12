/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package city.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author personal
 */
@Entity
@Table(name = "activacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activacion.findAll", query = "SELECT a FROM Activacion a")
    , @NamedQuery(name = "Activacion.findByIdActivacion", query = "SELECT a FROM Activacion a WHERE a.activacionPK.idActivacion = :idActivacion")
    , @NamedQuery(name = "Activacion.findByUserId", query = "SELECT a FROM Activacion a WHERE a.activacionPK.userId = :userId")
    , @NamedQuery(name = "Activacion.findByTokenActivacion", query = "SELECT a FROM Activacion a WHERE a.tokenActivacion = :tokenActivacion")
    , @NamedQuery(name = "Activacion.findByFechaCreacion", query = "SELECT a FROM Activacion a WHERE a.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Activacion.findByFechaCaducidad", query = "SELECT a FROM Activacion a WHERE a.fechaCaducidad = :fechaCaducidad")})
public class Activacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivacionPK activacionPK;
    @Column(name = "token_activacion")
    private String tokenActivacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCaducidad;
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Activacion() {
    }

    public Activacion(ActivacionPK activacionPK) {
        this.activacionPK = activacionPK;
    }

    public Activacion(int idActivacion, int userId) {
        this.activacionPK = new ActivacionPK(idActivacion, userId);
    }

    public ActivacionPK getActivacionPK() {
        return activacionPK;
    }

    public void setActivacionPK(ActivacionPK activacionPK) {
        this.activacionPK = activacionPK;
    }

    public String getTokenActivacion() {
        return tokenActivacion;
    }

    public void setTokenActivacion(String tokenActivacion) {
        this.tokenActivacion = tokenActivacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activacionPK != null ? activacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activacion)) {
            return false;
        }
        Activacion other = (Activacion) object;
        if ((this.activacionPK == null && other.activacionPK != null) || (this.activacionPK != null && !this.activacionPK.equals(other.activacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "city.modelo.Activacion[ activacionPK=" + activacionPK + " ]";
    }
    
}
