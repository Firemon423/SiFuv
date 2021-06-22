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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "domicilios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilios.findAll", query = "SELECT d FROM Domicilios d")
    , @NamedQuery(name = "Domicilios.findByIdDomicilio", query = "SELECT d FROM Domicilios d WHERE d.idDomicilio = :idDomicilio")
    , @NamedQuery(name = "Domicilios.findByPeso", query = "SELECT d FROM Domicilios d WHERE d.peso = :peso")
    , @NamedQuery(name = "Domicilios.findByTelefono", query = "SELECT d FROM Domicilios d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Domicilios.findByDireccion", query = "SELECT d FROM Domicilios d WHERE d.direccion = :direccion")})
public class Domicilios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_domicilio")
    private Integer idDomicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Peso")
    private String peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDomicilio")
    private Collection<Novedades> novedadesCollection;
    @JoinColumn(name = "id_domiciliario", referencedColumnName = "id_domiciliario")
    @ManyToOne(optional = false)
    private Domiciliario idDomiciliario;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "categorias", referencedColumnName = "categorias")
    @ManyToOne(optional = false)
    private Categoria categorias;

    public Domicilios() {
    }

    public Domicilios(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilios(Integer idDomicilio, String peso, String telefono, String direccion) {
        this.idDomicilio = idDomicilio;
        this.peso = peso;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Novedades> getNovedadesCollection() {
        return novedadesCollection;
    }

    public void setNovedadesCollection(Collection<Novedades> novedadesCollection) {
        this.novedadesCollection = novedadesCollection;
    }

    public Domiciliario getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(Domiciliario idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomicilio != null ? idDomicilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilios)) {
            return false;
        }
        Domicilios other = (Domicilios) object;
        if ((this.idDomicilio == null && other.idDomicilio != null) || (this.idDomicilio != null && !this.idDomicilio.equals(other.idDomicilio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Domicilios[ idDomicilio=" + idDomicilio + " ]";
    }
    
}
