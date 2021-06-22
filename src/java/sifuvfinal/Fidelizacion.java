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
@Table(name = "fidelizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fidelizacion.findAll", query = "SELECT f FROM Fidelizacion f")
    , @NamedQuery(name = "Fidelizacion.findByIdFidelizacion", query = "SELECT f FROM Fidelizacion f WHERE f.idFidelizacion = :idFidelizacion")
    , @NamedQuery(name = "Fidelizacion.findByPuntosAcumulados", query = "SELECT f FROM Fidelizacion f WHERE f.puntosAcumulados = :puntosAcumulados")
    , @NamedQuery(name = "Fidelizacion.findByNombreCliente", query = "SELECT f FROM Fidelizacion f WHERE f.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Fidelizacion.findByEstadoDelCliente", query = "SELECT f FROM Fidelizacion f WHERE f.estadoDelCliente = :estadoDelCliente")})
public class Fidelizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fidelizacion")
    private Integer idFidelizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos_acumulados")
    private int puntosAcumulados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_del_cliente")
    private String estadoDelCliente;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_ventas", referencedColumnName = "id_ventas")
    @ManyToOne(optional = false)
    private Ventas idVentas;

    public Fidelizacion() {
    }

    public Fidelizacion(Integer idFidelizacion) {
        this.idFidelizacion = idFidelizacion;
    }

    public Fidelizacion(Integer idFidelizacion, int puntosAcumulados, String nombreCliente, String estadoDelCliente) {
        this.idFidelizacion = idFidelizacion;
        this.puntosAcumulados = puntosAcumulados;
        this.nombreCliente = nombreCliente;
        this.estadoDelCliente = estadoDelCliente;
    }

    public Integer getIdFidelizacion() {
        return idFidelizacion;
    }

    public void setIdFidelizacion(Integer idFidelizacion) {
        this.idFidelizacion = idFidelizacion;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEstadoDelCliente() {
        return estadoDelCliente;
    }

    public void setEstadoDelCliente(String estadoDelCliente) {
        this.estadoDelCliente = estadoDelCliente;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Ventas getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Ventas idVentas) {
        this.idVentas = idVentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFidelizacion != null ? idFidelizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fidelizacion)) {
            return false;
        }
        Fidelizacion other = (Fidelizacion) object;
        if ((this.idFidelizacion == null && other.idFidelizacion != null) || (this.idFidelizacion != null && !this.idFidelizacion.equals(other.idFidelizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sifuvfinal.Fidelizacion[ idFidelizacion=" + idFidelizacion + " ]";
    }
    
}
