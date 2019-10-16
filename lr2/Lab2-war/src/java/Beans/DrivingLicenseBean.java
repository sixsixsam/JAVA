/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.*;
import Facade.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
/**
 *
 * @author INFERUS
 */
@Named(value = "drivingLicenseBean")
@RequestScoped
public class DrivingLicenseBean implements Serializable {
    @EJB
    DrivingLicenseFacadeLocal drivingLicenseFacadeLocal;
    @EJB
    DrivingLicenseCategoryFacadeLocal drivingLicenseCategoryFacadeLocal;
    
    public DrivingLicenseBean() {
        license = new DrivingLicense();
    }
    
    private DrivingLicense license;
    
    private Long categoryToAddId;

    public DrivingLicense getLicense() {
        return license;
    }

    public void setLicense(DrivingLicense license) {
        this.license = license;
    }

    public Long getCategoryToAddId() {
        return categoryToAddId;
    }

    public void setCategoryToAddId(Long categoryToAddId) {
        this.categoryToAddId = categoryToAddId;
    }
    
    
    public String create() {
//        long i = drivingLicenseFacadeLocal.count()+1;
//        license.setId(i);
        Date issDate = new Date();
        license.setIssueDate(issDate);
        Date expDate = new Date();
        expDate.setYear(expDate.getYear() + 10);
        license.setExpireDate(expDate);
        DrivingLicenseCategory category = drivingLicenseCategoryFacadeLocal.find(categoryToAddId);
        Collection<DrivingLicenseCategory> coll = new ArrayList<>();
        coll.add(category);
        license.setDrivingLicenseCategoryCollection(coll);
        drivingLicenseFacadeLocal.create(license);
        return "licenseList";
    }
    
    public String remove() {
        license = drivingLicenseFacadeLocal.findById((Long) license.getId());
        drivingLicenseFacadeLocal.remove(license);
        return "licenseList";
    }
    
    public String addCategory() {
        license = drivingLicenseFacadeLocal.findById((long) license.getId());
        DrivingLicenseCategory category = drivingLicenseCategoryFacadeLocal.findById((Long)categoryToAddId);
        license.getDrivingLicenseCategoryCollection().add(category);
        drivingLicenseFacadeLocal.edit(license);
        return "licenseList";
    }
    
    public Collection<DrivingLicense> getAll() {
        return drivingLicenseFacadeLocal.findAll();
    }
  
    
}
