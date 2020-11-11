/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "solicitud_compra_repuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudCompraRepuesto.findAll", query = "SELECT s FROM SolicitudCompraRepuesto s")
    , @NamedQuery(name = "SolicitudCompraRepuesto.findById", query = "SELECT s FROM SolicitudCompraRepuesto s WHERE s.id = :id")
    , @NamedQuery(name = "SolicitudCompraRepuesto.findByFecha", query = "SELECT s FROM SolicitudCompraRepuesto s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "SolicitudCompraRepuesto.findByCantidad", query = "SELECT s FROM SolicitudCompraRepuesto s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SolicitudCompraRepuesto.findByEstado", query = "SELECT s FROM SolicitudCompraRepuesto s WHERE s.estado = :estado")})
public class SolicitudCompraRepuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @ManyToMany(mappedBy = "solicitudCompraRepuestoList", fetch = FetchType.LAZY)
    private List<Repuesto> repuestoList;
    @JoinColumn(name = "logistica", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Logistica logistica;
    @JoinColumn(name = "pedido", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudCompraRepuesto", fetch = FetchType.LAZY)
    private List<OrdenCompraRepuesto> ordenCompraRepuestoList;

    public SolicitudCompraRepuesto() {
    }

    public SolicitudCompraRepuesto(Integer id) {
        this.id = id;
    }

    public SolicitudCompraRepuesto(Integer id, Date fecha, int cantidad, int estado) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Repuesto> getRepuestoList() {
        return repuestoList;
    }

    public void setRepuestoList(List<Repuesto> repuestoList) {
        this.repuestoList = repuestoList;
    }

    public Logistica getLogistica() {
        return logistica;
    }

    public void setLogistica(Logistica logistica) {
        this.logistica = logistica;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @XmlTransient
    public List<OrdenCompraRepuesto> getOrdenCompraRepuestoList() {
        return ordenCompraRepuestoList;
    }

    public void setOrdenCompraRepuestoList(List<OrdenCompraRepuesto> ordenCompraRepuestoList) {
        this.ordenCompraRepuestoList = ordenCompraRepuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCompraRepuesto)) {
            return false;
        }
        SolicitudCompraRepuesto other = (SolicitudCompraRepuesto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " ";
    }
    
}
