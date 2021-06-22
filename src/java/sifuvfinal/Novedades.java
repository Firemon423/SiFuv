/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifuvfinal;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedades.findAll", query = "SELECT n FROM Novedades n")
    , @NamedQuery(name = "Novedades.findByIdNovedad", query = "SELECT n FROM Novedades n WHERE n.idNovedad = :idNovedad")
    , @NamedQuery(name = "Novedades.findByNovedad", query = "SELECT n FROM Novedades n WHERE n.novedad = :novedad")})
public class Novedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_novedad")
    private Integer idNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "novedad")
    private String novedad;
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne(optional = false)
    private Domicilios idDomicilio;
    @JoinColumn(name = "id_domiciliario", referencedColumnName = "id_domiciliario")
    @ManyToOne(optional = false)
    private Domiciliario idDomiciliario;

    public Novedades() {
    }

    public Novedades(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Novedades(Integer idNovedad, String novedad) {
        this.idNovedad = idNovedad;
        this.novedad = novedad;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public Domicilios getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Domicilios idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domiciliario getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(Domiciliario idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedad != null ? idNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedades)) {
            return false;
        }
        Novedades other = (Novedades) object;
        if ((this.idNovedad == null && other.idNovedad != null) || (this.idNovedad != null && !this.idNovedad.equals(other.idNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Novedades[ idNovedad=" + idNovedad + " ]";
    }
    
}
