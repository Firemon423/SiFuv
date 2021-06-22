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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByCategorias", query = "SELECT c FROM Categoria c WHERE c.categorias = :categorias")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "categorias")
    private Integer categorias;
    @JoinColumn(name = "id_frutas", referencedColumnName = "id_frutas")
    @ManyToOne(optional = false)
    private Frutas idFrutas;
    @JoinColumn(name = "id_verduras", referencedColumnName = "id_verduras")
    @ManyToOne(optional = false)
    private Verduras idVerduras;
    @JoinColumn(name = "id_granos", referencedColumnName = "id_granos")
    @ManyToOne(optional = false)
    private Granos idGranos;
    @JoinColumn(name = "id_especias", referencedColumnName = "id_especias")
    @ManyToOne(optional = false)
    private Especias idEspecias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias")
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias")
    private Collection<Domicilios> domiciliosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias")
    private Collection<Inventario> inventarioCollection;

    public Categoria() {
    }

    public Categoria(Integer categorias) {
        this.categorias = categorias;
    }

    public Integer getCategorias() {
        return categorias;
    }

    public void setCategorias(Integer categorias) {
        this.categorias = categorias;
    }

    public Frutas getIdFrutas() {
        return idFrutas;
    }

    public void setIdFrutas(Frutas idFrutas) {
        this.idFrutas = idFrutas;
    }

    public Verduras getIdVerduras() {
        return idVerduras;
    }

    public void setIdVerduras(Verduras idVerduras) {
        this.idVerduras = idVerduras;
    }

    public Granos getIdGranos() {
        return idGranos;
    }

    public void setIdGranos(Granos idGranos) {
        this.idGranos = idGranos;
    }

    public Especias getIdEspecias() {
        return idEspecias;
    }

    public void setIdEspecias(Especias idEspecias) {
        this.idEspecias = idEspecias;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<Domicilios> getDomiciliosCollection() {
        return domiciliosCollection;
    }

    public void setDomiciliosCollection(Collection<Domicilios> domiciliosCollection) {
        this.domiciliosCollection = domiciliosCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categorias != null ? categorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.categorias == null && other.categorias != null) || (this.categorias != null && !this.categorias.equals(other.categorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Categoria[ categorias=" + categorias + " ]";
    }
    
}
