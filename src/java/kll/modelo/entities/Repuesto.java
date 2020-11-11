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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "repuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repuesto.findAll", query = "SELECT r FROM Repuesto r")
    , @NamedQuery(name = "Repuesto.findById", query = "SELECT r FROM Repuesto r WHERE r.id = :id")
    , @NamedQuery(name = "Repuesto.findByFechaRegistroRepuesto", query = "SELECT r FROM Repuesto r WHERE r.fechaRegistroRepuesto = :fechaRegistroRepuesto")
    , @NamedQuery(name = "Repuesto.findByNombreRepuesto", query = "SELECT r FROM Repuesto r WHERE r.nombreRepuesto = :nombreRepuesto")
    , @NamedQuery(name = "Repuesto.findByMarca", query = "SELECT r FROM Repuesto r WHERE r.marca = :marca")
    , @NamedQuery(name = "Repuesto.findByDescripcionRepuesto", query = "SELECT r FROM Repuesto r WHERE r.descripcionRepuesto = :descripcionRepuesto")
    , @NamedQuery(name = "Repuesto.findByCantidad", query = "SELECT r FROM Repuesto r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Repuesto.findByValorCompra", query = "SELECT r FROM Repuesto r WHERE r.valorCompra = :valorCompra")
    , @NamedQuery(name = "Repuesto.findByValorVenta", query = "SELECT r FROM Repuesto r WHERE r.valorVenta = :valorVenta")
    , @NamedQuery(name = "Repuesto.findByEstado", query = "SELECT r FROM Repuesto r WHERE r.estado = :estado")})
public class Repuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_Registro_Repuesto")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroRepuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_Repuesto")
    private String nombreRepuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion_repuesto")
    private String descripcionRepuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_Compra")
    private double valorCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_Venta")
    private double valorVenta;
    @Column(name = "estado")
    private Integer estado;
    @ManyToMany(mappedBy = "repuestoList", fetch = FetchType.LAZY)
    private List<Factura> facturaList;
    @JoinTable(name = "solicitud_compra_repuestos_has_repuesto", joinColumns = {
        @JoinColumn(name = "repuesto", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "solicitud_compra_repuesto", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<SolicitudCompraRepuesto> solicitudCompraRepuestoList;
    @ManyToMany(mappedBy = "repuestoList", fetch = FetchType.LAZY)
    private List<Despacho> despachoList;
    @ManyToMany(mappedBy = "repuestoList", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @ManyToMany(mappedBy = "repuestoList", fetch = FetchType.LAZY)
    private List<Proveedor> proveedorList;
    @JoinColumn(name = "tipo_Repuesto", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoRepuesto tipoRepuesto;

    public Repuesto() {
    }

    public Repuesto(Integer id) {
        this.id = id;
    }

    public Repuesto(Integer id, Date fechaRegistroRepuesto, String nombreRepuesto, String marca, byte[] imagen, String descripcionRepuesto, int cantidad, double valorCompra, double valorVenta) {
        this.id = id;
        this.fechaRegistroRepuesto = fechaRegistroRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.marca = marca;
        this.imagen = imagen;
        this.descripcionRepuesto = descripcionRepuesto;
        this.cantidad = cantidad;
        this.valorCompra = valorCompra;
        this.valorVenta = valorVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaRegistroRepuesto() {
        return fechaRegistroRepuesto;
    }

    public void setFechaRegistroRepuesto(Date fechaRegistroRepuesto) {
        this.fechaRegistroRepuesto = fechaRegistroRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }

    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<SolicitudCompraRepuesto> getSolicitudCompraRepuestoList() {
        return solicitudCompraRepuestoList;
    }

    public void setSolicitudCompraRepuestoList(List<SolicitudCompraRepuesto> solicitudCompraRepuestoList) {
        this.solicitudCompraRepuestoList = solicitudCompraRepuestoList;
    }

    @XmlTransient
    public List<Despacho> getDespachoList() {
        return despachoList;
    }

    public void setDespachoList(List<Despacho> despachoList) {
        this.despachoList = despachoList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    public TipoRepuesto getTipoRepuesto() {
        return tipoRepuesto;
    }

    public void setTipoRepuesto(TipoRepuesto tipoRepuesto) {
        this.tipoRepuesto = tipoRepuesto;
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
        if (!(object instanceof Repuesto)) {
            return false;
        }
        Repuesto other = (Repuesto) object;
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
