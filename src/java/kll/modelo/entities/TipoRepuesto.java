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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author alejo
 */
@Entity
@Table(name = "tipo_repuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRepuesto.findAll", query = "SELECT t FROM TipoRepuesto t")
    , @NamedQuery(name = "TipoRepuesto.findById", query = "SELECT t FROM TipoRepuesto t WHERE t.id = :id")
    , @NamedQuery(name = "TipoRepuesto.findByNombreTipoRepuesto", query = "SELECT t FROM TipoRepuesto t WHERE t.nombreTipoRepuesto = :nombreTipoRepuesto")})
public class TipoRepuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombre_Tipo_Repuesto")
    private String nombreTipoRepuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoRepuesto", fetch = FetchType.LAZY)
    private List<Repuesto> repuestoList;

    public TipoRepuesto() {
    }

    public TipoRepuesto(Integer id) {
        this.id = id;
    }

    public TipoRepuesto(Integer id, String nombreTipoRepuesto) {
        this.id = id;
        this.nombreTipoRepuesto = nombreTipoRepuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipoRepuesto() {
        return nombreTipoRepuesto;
    }

    public void setNombreTipoRepuesto(String nombreTipoRepuesto) {
        this.nombreTipoRepuesto = nombreTipoRepuesto;
    }

    @XmlTransient
    public List<Repuesto> getRepuestoList() {
        return repuestoList;
    }

    public void setRepuestoList(List<Repuesto> repuestoList) {
        this.repuestoList = repuestoList;
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
        if (!(object instanceof TipoRepuesto)) {
            return false;
        }
        TipoRepuesto other = (TipoRepuesto) object;
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
