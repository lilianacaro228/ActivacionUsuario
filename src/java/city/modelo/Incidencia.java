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
import javax.persistence.Lob;
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
@Table(name = "incidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i")
    , @NamedQuery(name = "Incidencia.findByIdIncidencia", query = "SELECT i FROM Incidencia i WHERE i.incidenciaPK.idIncidencia = :idIncidencia")
    , @NamedQuery(name = "Incidencia.findByIdUser", query = "SELECT i FROM Incidencia i WHERE i.incidenciaPK.idUser = :idUser")
    , @NamedQuery(name = "Incidencia.findByCategoriaIncidencia", query = "SELECT i FROM Incidencia i WHERE i.incidenciaPK.categoriaIncidencia = :categoriaIncidencia")
    , @NamedQuery(name = "Incidencia.findByFechaCreacion", query = "SELECT i FROM Incidencia i WHERE i.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Incidencia.findByFechaModificacion", query = "SELECT i FROM Incidencia i WHERE i.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Incidencia.findByTitulo", query = "SELECT i FROM Incidencia i WHERE i.titulo = :titulo")
    , @NamedQuery(name = "Incidencia.findByLatitud", query = "SELECT i FROM Incidencia i WHERE i.latitud = :latitud")
    , @NamedQuery(name = "Incidencia.findByLongitud", query = "SELECT i FROM Incidencia i WHERE i.longitud = :longitud")
    , @NamedQuery(name = "Incidencia.findByBarrioSector", query = "SELECT i FROM Incidencia i WHERE i.barrioSector = :barrioSector")
    , @NamedQuery(name = "Incidencia.findByDescripcionAdicional", query = "SELECT i FROM Incidencia i WHERE i.descripcionAdicional = :descripcionAdicional")
    , @NamedQuery(name = "Incidencia.findByEstado", query = "SELECT i FROM Incidencia i WHERE i.estado = :estado")
    , @NamedQuery(name = "Incidencia.findByEliminado", query = "SELECT i FROM Incidencia i WHERE i.eliminado = :eliminado")})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IncidenciaPK incidenciaPK;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Column(name = "multimedia")
    private byte[] multimedia;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "barrio_sector")
    private String barrioSector;
    @Column(name = "descripcion_adicional")
    private String descripcionAdicional;
    @Column(name = "estado")
    private String estado;
    @Column(name = "eliminado")
    private String eliminado;
    @JoinColumn(name = "categoria_incidencia", referencedColumnName = "idCategorias", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categorias categorias;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Incidencia() {
    }

    public Incidencia(IncidenciaPK incidenciaPK) {
        this.incidenciaPK = incidenciaPK;
    }

    public Incidencia(int idIncidencia, int idUser, int categoriaIncidencia) {
        this.incidenciaPK = new IncidenciaPK(idIncidencia, idUser, categoriaIncidencia);
    }

    public IncidenciaPK getIncidenciaPK() {
        return incidenciaPK;
    }

    public void setIncidenciaPK(IncidenciaPK incidenciaPK) {
        this.incidenciaPK = incidenciaPK;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(byte[] multimedia) {
        this.multimedia = multimedia;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getBarrioSector() {
        return barrioSector;
    }

    public void setBarrioSector(String barrioSector) {
        this.barrioSector = barrioSector;
    }

    public String getDescripcionAdicional() {
        return descripcionAdicional;
    }

    public void setDescripcionAdicional(String descripcionAdicional) {
        this.descripcionAdicional = descripcionAdicional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
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
        hash += (incidenciaPK != null ? incidenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.incidenciaPK == null && other.incidenciaPK != null) || (this.incidenciaPK != null && !this.incidenciaPK.equals(other.incidenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "city.modelo.Incidencia[ incidenciaPK=" + incidenciaPK + " ]";
    }
    
}
