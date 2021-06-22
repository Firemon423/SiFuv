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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "domiciliario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domiciliario.findAll", query = "SELECT d FROM Domiciliario d")
    , @NamedQuery(name = "Domiciliario.findByIdDomiciliario", query = "SELECT d FROM Domiciliario d WHERE d.idDomiciliario = :idDomiciliario")
    , @NamedQuery(name = "Domiciliario.findByTelefono", query = "SELECT d FROM Domiciliario d WHERE d.telefono = :telefono")})
public class Domiciliario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_domiciliario")
    private Integer idDomiciliario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDomiciliario")
    private Collection<Novedades> novedadesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDomiciliario")
    private Collection<Domicilios> domiciliosCollection;

    public Domiciliario() {
    }

    public Domiciliario(Integer idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public Domiciliario(Integer idDomiciliario, String telefono) {
        this.idDomiciliario = idDomiciliario;
        this.telefono = telefono;
    }

    public Integer getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(Integer idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Novedades> getNovedadesCollection() {
        return novedadesCollection;
    }

    public void setNovedadesCollection(Collection<Novedades> novedadesCollection) {
        this.novedadesCollection = novedadesCollection;
    }

    @XmlTransient
    public Collection<Domicilios> getDomiciliosCollection() {
        return domiciliosCollection;
    }

    public void setDomiciliosCollection(Collection<Domicilios> domiciliosCollection) {
        this.domiciliosCollection = domiciliosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDomiciliario != null ? idDomiciliario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domiciliario)) {
            return false;
        }
        Domiciliario other = (Domiciliario) object;
        if ((this.idDomiciliario == null && other.idDomiciliario != null) || (this.idDomiciliario != null && !this.idDomiciliario.equals(other.idDomiciliario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Domiciliario[ idDomiciliario=" + idDomiciliario + " ]";
    }
    
}
