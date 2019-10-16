/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
 * @author INFERUS
 */
@Entity
@Table(name = "driving_license_category")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrivingLicenseCategory.findAll", query = "SELECT d FROM DrivingLicenseCategory d")
    , @NamedQuery(name = "DrivingLicenseCategory.findById", query = "SELECT d FROM DrivingLicenseCategory d WHERE d.id = :id")
    , @NamedQuery(name = "DrivingLicenseCategory.findByCategoryName", query = "SELECT d FROM DrivingLicenseCategory d WHERE d.categoryName = :categoryName")})
public class DrivingLicenseCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 255)
    @Column(name = "category_name")
    private String categoryName;
    @JoinTable(name = "license_category", joinColumns = {
        @JoinColumn(name = "category_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "license_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<DrivingLicense> drivingLicenseCollection;

    public DrivingLicenseCategory() {
    }

    public DrivingLicenseCategory(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @XmlTransient
    public Collection<DrivingLicense> getDrivingLicenseCollection() {
        return drivingLicenseCollection;
    }

    public void setDrivingLicenseCollection(Collection<DrivingLicense> drivingLicenseCollection) {
        this.drivingLicenseCollection = drivingLicenseCollection;
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
        if (!(object instanceof DrivingLicenseCategory)) {
            return false;
        }
        DrivingLicenseCategory other = (DrivingLicenseCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DrivingLicenseCategory[ id=" + id + " ]";
    }
    
}
