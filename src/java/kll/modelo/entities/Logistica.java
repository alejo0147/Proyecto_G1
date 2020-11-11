/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "logistica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logistica.findAll", query = "SELECT l FROM Logistica l")
    , @NamedQuery(name = "Logistica.findById", query = "SELECT l FROM Logistica l WHERE l.id = :id")
    , @NamedQuery(name = "Logistica.findByEstado", query = "SELECT l FROM Logistica l WHERE l.estado = :estado")})
public class Logistica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logistica", fetch = FetchType.LAZY)
    private List<SolicitudCompraRepuesto> solicitudCompraRepuestoList;

    public Logistica() {
    }

    public Logistica(Integer id) {
        this.id = id;
    }

    public Logistica(Integer id, int estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<SolicitudCompraRepuesto> getSolicitudCompraRepuestoList() {
        return solicitudCompraRepuestoList;
    }

    public void setSolicitudCompraRepuestoList(List<SolicitudCompraRepuesto> solicitudCompraRepuestoList) {
        this.solicitudCompraRepuestoList = solicitudCompraRepuestoList;
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
        if (!(object instanceof Logistica)) {
            return false;
        }
        Logistica other = (Logistica) object;
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
