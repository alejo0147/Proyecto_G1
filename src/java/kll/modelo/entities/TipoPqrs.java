/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kll.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejo
 */
@Entity
@Table(name = "tipo_pqrs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPqrs.findAll", query = "SELECT t FROM TipoPqrs t")
    , @NamedQuery(name = "TipoPqrs.findById", query = "SELECT t FROM TipoPqrs t WHERE t.id = :id")
    , @NamedQuery(name = "TipoPqrs.findByNombrePQRS", query = "SELECT t FROM TipoPqrs t WHERE t.nombrePQRS = :nombrePQRS")
    , @NamedQuery(name = "TipoPqrs.findByDescripcionPQRS", query = "SELECT t FROM TipoPqrs t WHERE t.descripcionPQRS = :descripcionPQRS")
    , @NamedQuery(name = "TipoPqrs.findByEstado", query = "SELECT t FROM TipoPqrs t WHERE t.estado = :estado")})
public class TipoPqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre_PQRS")
    private String nombrePQRS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "descripcion_PQRS")
    private String descripcionPQRS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @ManyToMany(mappedBy = "tipoPqrsList", fetch = FetchType.LAZY)
    private List<Pqrs> pqrsList;

    public TipoPqrs() {
    }

    public TipoPqrs(Integer id) {
        this.id = id;
    }

    public TipoPqrs(Integer id, String nombrePQRS, String descripcionPQRS, int estado) {
        this.id = id;
        this.nombrePQRS = nombrePQRS;
        this.descripcionPQRS = descripcionPQRS;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePQRS() {
        return nombrePQRS;
    }

    public void setNombrePQRS(String nombrePQRS) {
        this.nombrePQRS = nombrePQRS;
    }

    public String getDescripcionPQRS() {
        return descripcionPQRS;
    }

    public void setDescripcionPQRS(String descripcionPQRS) {
        this.descripcionPQRS = descripcionPQRS;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Pqrs> getPqrsList() {
        return pqrsList;
    }

    public void setPqrsList(List<Pqrs> pqrsList) {
        this.pqrsList = pqrsList;
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
        if (!(object instanceof TipoPqrs)) {
            return false;
        }
        TipoPqrs other = (TipoPqrs) object;
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
