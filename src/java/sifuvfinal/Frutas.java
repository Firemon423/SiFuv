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
@Table(name = "frutas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frutas.findAll", query = "SELECT f FROM Frutas f")
    , @NamedQuery(name = "Frutas.findByIdFrutas", query = "SELECT f FROM Frutas f WHERE f.idFrutas = :idFrutas")
    , @NamedQuery(name = "Frutas.findByNombreFruta", query = "SELECT f FROM Frutas f WHERE f.nombreFruta = :nombreFruta")
    , @NamedQuery(name = "Frutas.findByPrecioUnidad", query = "SELECT f FROM Frutas f WHERE f.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Frutas.findByPrecioLibra", query = "SELECT f FROM Frutas f WHERE f.precioLibra = :precioLibra")})
public class Frutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frutas")
    private Integer idFrutas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_fruta")
    private String nombreFruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unidad")
    private int precioUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_libra")
    private int precioLibra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFrutas")
    private Collection<Categoria> categoriaCollection;

    public Frutas() {
    }

    public Frutas(Integer idFrutas) {
        this.idFrutas = idFrutas;
    }

    public Frutas(Integer idFrutas, String nombreFruta, int precioUnidad, int precioLibra) {
        this.idFrutas = idFrutas;
        this.nombreFruta = nombreFruta;
        this.precioUnidad = precioUnidad;
        this.precioLibra = precioLibra;
    }

    public Integer getIdFrutas() {
        return idFrutas;
    }

    public void setIdFrutas(Integer idFrutas) {
        this.idFrutas = idFrutas;
    }

    public String getNombreFruta() {
        return nombreFruta;
    }

    public void setNombreFruta(String nombreFruta) {
        this.nombreFruta = nombreFruta;
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
        hash += (idFrutas != null ? idFrutas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frutas)) {
            return false;
        }
        Frutas other = (Frutas) object;
        if ((this.idFrutas == null && other.idFrutas != null) || (this.idFrutas != null && !this.idFrutas.equals(other.idFrutas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Frutas[ idFrutas=" + idFrutas + " ]";
    }
    
}
