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
@Table(name = "verduras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Verduras.findAll", query = "SELECT v FROM Verduras v")
    , @NamedQuery(name = "Verduras.findByIdVerduras", query = "SELECT v FROM Verduras v WHERE v.idVerduras = :idVerduras")
    , @NamedQuery(name = "Verduras.findByNombreVerdura", query = "SELECT v FROM Verduras v WHERE v.nombreVerdura = :nombreVerdura")
    , @NamedQuery(name = "Verduras.findByPrecioUnidad", query = "SELECT v FROM Verduras v WHERE v.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Verduras.findByPrecioLibra", query = "SELECT v FROM Verduras v WHERE v.precioLibra = :precioLibra")})
public class Verduras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_verduras")
    private Integer idVerduras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_verdura")
    private String nombreVerdura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unidad")
    private int precioUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_libra")
    private int precioLibra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVerduras")
    private Collection<Categoria> categoriaCollection;

    public Verduras() {
    }

    public Verduras(Integer idVerduras) {
        this.idVerduras = idVerduras;
    }

    public Verduras(Integer idVerduras, String nombreVerdura, int precioUnidad, int precioLibra) {
        this.idVerduras = idVerduras;
        this.nombreVerdura = nombreVerdura;
        this.precioUnidad = precioUnidad;
        this.precioLibra = precioLibra;
    }

    public Integer getIdVerduras() {
        return idVerduras;
    }

    public void setIdVerduras(Integer idVerduras) {
        this.idVerduras = idVerduras;
    }

    public String getNombreVerdura() {
        return nombreVerdura;
    }

    public void setNombreVerdura(String nombreVerdura) {
        this.nombreVerdura = nombreVerdura;
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
        hash += (idVerduras != null ? idVerduras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Verduras)) {
            return false;
        }
        Verduras other = (Verduras) object;
        if ((this.idVerduras == null && other.idVerduras != null) || (this.idVerduras != null && !this.idVerduras.equals(other.idVerduras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Verduras[ idVerduras=" + idVerduras + " ]";
    }
    
}
