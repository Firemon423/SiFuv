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
@Table(name = "especias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especias.findAll", query = "SELECT e FROM Especias e")
    , @NamedQuery(name = "Especias.findByIdEspecias", query = "SELECT e FROM Especias e WHERE e.idEspecias = :idEspecias")
    , @NamedQuery(name = "Especias.findByNombreEspecia", query = "SELECT e FROM Especias e WHERE e.nombreEspecia = :nombreEspecia")
    , @NamedQuery(name = "Especias.findByPrecioUnidad", query = "SELECT e FROM Especias e WHERE e.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Especias.findByPrecioLibra", query = "SELECT e FROM Especias e WHERE e.precioLibra = :precioLibra")})
public class Especias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especias")
    private Integer idEspecias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_especia")
    private String nombreEspecia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unidad")
    private int precioUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_libra")
    private int precioLibra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecias")
    private Collection<Categoria> categoriaCollection;

    public Especias() {
    }

    public Especias(Integer idEspecias) {
        this.idEspecias = idEspecias;
    }

    public Especias(Integer idEspecias, String nombreEspecia, int precioUnidad, int precioLibra) {
        this.idEspecias = idEspecias;
        this.nombreEspecia = nombreEspecia;
        this.precioUnidad = precioUnidad;
        this.precioLibra = precioLibra;
    }

    public Integer getIdEspecias() {
        return idEspecias;
    }

    public void setIdEspecias(Integer idEspecias) {
        this.idEspecias = idEspecias;
    }

    public String getNombreEspecia() {
        return nombreEspecia;
    }

    public void setNombreEspecia(String nombreEspecia) {
        this.nombreEspecia = nombreEspecia;
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
        hash += (idEspecias != null ? idEspecias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especias)) {
            return false;
        }
        Especias other = (Especias) object;
        if ((this.idEspecias == null && other.idEspecias != null) || (this.idEspecias != null && !this.idEspecias.equals(other.idEspecias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Especias[ idEspecias=" + idEspecias + " ]";
    }
    
}
