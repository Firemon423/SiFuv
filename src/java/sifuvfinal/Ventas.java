/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifuvfinal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdVentas", query = "SELECT v FROM Ventas v WHERE v.idVentas = :idVentas")
    , @NamedQuery(name = "Ventas.findByFechaVenta", query = "SELECT v FROM Ventas v WHERE v.fechaVenta = :fechaVenta")
    , @NamedQuery(name = "Ventas.findByValorTotal", query = "SELECT v FROM Ventas v WHERE v.valorTotal = :valorTotal")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ventas")
    private Integer idVentas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "valor_total")
    private String valorTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVentas")
    private Collection<Fidelizacion> fidelizacionCollection;
    @JoinColumn(name = "id_cajero", referencedColumnName = "id_cajero")
    @ManyToOne(optional = false)
    private Cajero idCajero;
    @JoinColumn(name = "id_administrador", referencedColumnName = "id_administrador")
    @ManyToOne(optional = false)
    private Administrador idAdministrador;

    public Ventas() {
    }

    public Ventas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Ventas(Integer idVentas, Date fechaVenta, String valorTotal) {
        this.idVentas = idVentas;
        this.fechaVenta = fechaVenta;
        this.valorTotal = valorTotal;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    @XmlTransient
    public Collection<Fidelizacion> getFidelizacionCollection() {
        return fidelizacionCollection;
    }

    public void setFidelizacionCollection(Collection<Fidelizacion> fidelizacionCollection) {
        this.fidelizacionCollection = fidelizacionCollection;
    }

    public Cajero getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Cajero idCajero) {
        this.idCajero = idCajero;
    }

    public Administrador getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Administrador idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentas != null ? idVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVentas == null && other.idVentas != null) || (this.idVentas != null && !this.idVentas.equals(other.idVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Ventas[ idVentas=" + idVentas + " ]";
    }
    
}
