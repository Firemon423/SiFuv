/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifuvfinal;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "granos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Granos.findAll", query = "SELECT g FROM Granos g")
    , @NamedQuery(name = "Granos.findByIdGranos", query = "SELECT g FROM Granos g WHERE g.idGranos = :idGranos")
    , @NamedQuery(name = "Granos.findByNombreGrano", query = "SELECT g FROM Granos g WHERE g.nombreGrano = :nombreGrano")
    , @NamedQuery(name = "Granos.findByPrecioUnidad", query = "SELECT g FROM Granos g WHERE g.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Granos.findByPrecioLibra", query = "SELECT g FROM Granos g WHERE g.precioLibra = :precioLibra")})
public class Granos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_granos")
    private Integer idGranos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_grano")
    private String nombreGrano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unidad")
    private int precioUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_libra")
    private int precioLibra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGranos")
    private Collection<Categoria> categoriaCollection;

    public Granos() {
    }

    public Granos(Integer idGranos) {
        this.idGranos = idGranos;
    }

    public Granos(Integer idGranos, String nombreGrano, int precioUnidad, int precioLibra) {
        this.idGranos = idGranos;
        this.nombreGrano = nombreGrano;
        this.precioUnidad = precioUnidad;
        this.precioLibra = precioLibra;
    }

    public Integer getIdGranos() {
        return idGranos;
    }

    public void setIdGranos(Integer idGranos) {
        this.idGranos = idGranos;
    }

    public String getNombreGrano() {
        return nombreGrano;
    }

    public void setNombreGrano(String nombreGrano) {
        this.nombreGrano = nombreGrano;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getPrecioLibra() {
        return precioLibra;
    }

    public void setPrecioLibra(int precioLibra) {
        this.precioLibra = precioLibra;
    }

    @XmlTransient
    public Collection<Categoria> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGranos != null ? idGranos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Granos)) {
            return false;
        }
        Granos other = (Granos) object;
        if ((this.idGranos == null && other.idGranos != null) || (this.idGranos != null && !this.idGranos.equals(other.idGranos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Granos[ idGranos=" + idGranos + " ]";
    }
    
}
