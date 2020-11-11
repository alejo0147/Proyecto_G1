/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "orden_compra_repuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompraRepuesto.findAll", query = "SELECT o FROM OrdenCompraRepuesto o")
    , @NamedQuery(name = "OrdenCompraRepuesto.findById", query = "SELECT o FROM OrdenCompraRepuesto o WHERE o.id = :id")
    , @NamedQuery(name = "OrdenCompraRepuesto.findByFecha", query = "SELECT o FROM OrdenCompraRepuesto o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "OrdenCompraRepuesto.findByCantidad", query = "SELECT o FROM OrdenCompraRepuesto o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenCompraRepuesto.findByValorUnitario", query = "SELECT o FROM OrdenCompraRepuesto o WHERE o.valorUnitario = :valorUnitario")
    , @NamedQuery(name = "OrdenCompraRepuesto.findByValorIva", query = "SELECT o FROM OrdenCompraRepuesto o WHERE o.valorIva = :valorIva")
    , @NamedQuery(name = "OrdenCompraRepuesto.findByValorTotal", query = "SELECT o FROM OrdenCompraRepuesto o WHERE o.valorTotal = :valorTotal")
    , @NamedQuery(name = "OrdenCompraRepuesto.findByEstado", query = "SELECT o FROM OrdenCompraRepuesto o WHERE o.estado = :estado")})
public class OrdenCompraRepuesto implements Serializable {

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
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_Iva")
    private double valorIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_Total")
    private double valorTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "solicitud_Compra_Repuesto", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SolicitudCompraRepuesto solicitudCompraRepuesto;
    @JoinColumn(name = "vendedor", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vendedor vendedor;

    public OrdenCompraRepuesto() {
    }

    public OrdenCompraRepuesto(Integer id) {
        this.id = id;
    }

    public OrdenCompraRepuesto(Integer id, Date fecha, int cantidad, double valorUnitario, double valorIva, double valorTotal, int estado) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.valorIva = valorIva;
        this.valorTotal = valorTotal;
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

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public SolicitudCompraRepuesto getSolicitudCompraRepuesto() {
        return solicitudCompraRepuesto;
    }

    public void setSolicitudCompraRepuesto(SolicitudCompraRepuesto solicitudCompraRepuesto) {
        this.solicitudCompraRepuesto = solicitudCompraRepuesto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
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
        if (!(object instanceof OrdenCompraRepuesto)) {
            return false;
        }
        OrdenCompraRepuesto other = (OrdenCompraRepuesto) object;
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
