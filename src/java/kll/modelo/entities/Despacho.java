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
@Table(name = "despacho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despacho.findAll", query = "SELECT d FROM Despacho d")
    , @NamedQuery(name = "Despacho.findById", query = "SELECT d FROM Despacho d WHERE d.id = :id")
    , @NamedQuery(name = "Despacho.findByFecha", query = "SELECT d FROM Despacho d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "Despacho.findByNombreCliente", query = "SELECT d FROM Despacho d WHERE d.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Despacho.findByDireccionCliente", query = "SELECT d FROM Despacho d WHERE d.direccionCliente = :direccionCliente")
    , @NamedQuery(name = "Despacho.findByTelefono", query = "SELECT d FROM Despacho d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Despacho.findByDescripcionDespacho", query = "SELECT d FROM Despacho d WHERE d.descripcionDespacho = :descripcionDespacho")
    , @NamedQuery(name = "Despacho.findByCantidad", query = "SELECT d FROM Despacho d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Despacho.findByEstado", query = "SELECT d FROM Despacho d WHERE d.estado = :estado")})
public class Despacho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre_Cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "direccion_Cliente")
    private String direccionCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "descripcion_Despacho")
    private String descripcionDespacho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinTable(name = "despacho_has_repuesto", joinColumns = {
        @JoinColumn(name = "despacho", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "repuesto", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Repuesto> repuestoList;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "pedido", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;

    public Despacho() {
    }

    public Despacho(Integer id) {
        this.id = id;
    }

    public Despacho(Integer id, Date fecha, String nombreCliente, String direccionCliente, int telefono, String descripcionDespacho, int cantidad, int estado) {
        this.id = id;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.telefono = telefono;
        this.descripcionDespacho = descripcionDespacho;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDescripcionDespacho() {
        return descripcionDespacho;
    }

    public void setDescripcionDespacho(String descripcionDespacho) {
        this.descripcionDespacho = descripcionDespacho;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        if (!(object instanceof Despacho)) {
            return false;
        }
        Despacho other = (Despacho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id + " ";
    }
    
}
