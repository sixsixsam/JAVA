/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author INFERUS
 */
@Entity
@Table(name = "driving_license")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrivingLicense.findAll", query = "SELECT d FROM DrivingLicense d")
    , @NamedQuery(name = "DrivingLicense.findById", query = "SELECT d FROM DrivingLicense d WHERE d.id = :id")
    , @NamedQuery(name = "DrivingLicense.findByExpireDate", query = "SELECT d FROM DrivingLicense d WHERE d.expireDate = :expireDate")
    , @NamedQuery(name = "DrivingLicense.findByIssueDate", query = "SELECT d FROM DrivingLicense d WHERE d.issueDate = :issueDate")})
public class DrivingLicense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date expireDate;
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @ManyToMany(mappedBy = "drivingLicenseCollection")
    private Collection<DrivingLicenseCategory> drivingLicenseCategoryCollection;
    @OneToMany(mappedBy = "drivingLicenseId")
    private Collection<Person> personCollection;

    public DrivingLicense() {
    }

    public DrivingLicense(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @XmlTransient
    public Collection<DrivingLicenseCategory> getDrivingLicenseCategoryCollection() {
        return drivingLicenseCategoryCollection;
    }

    public void setDrivingLicenseCategoryCollection(Collection<DrivingLicenseCategory> drivingLicenseCategoryCollection) {
        this.drivingLicenseCategoryCollection = drivingLicenseCategoryCollection;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
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
        if (!(object instanceof DrivingLicense)) {
            return false;
        }
        DrivingLicense other = (DrivingLicense) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DrivingLicense[ id=" + id + " ]";
    }

    
}
