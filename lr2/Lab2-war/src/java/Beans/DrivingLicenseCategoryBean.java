/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entity.*;
import Facade.*;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author INFERUS
 */
@Named(value = "licenseCategoryBean")
@RequestScoped
public class DrivingLicenseCategoryBean implements Serializable {
    
    @EJB
    DrivingLicenseCategoryFacadeLocal drivingLicenseCategoryFacadeLocal;
    
    public DrivingLicenseCategoryBean() {
        licenseCategory = new DrivingLicenseCategory();
    }
    
    DrivingLicenseCategory licenseCategory;

    public DrivingLicenseCategory getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(DrivingLicenseCategory licenseCategory) {
        this.licenseCategory = licenseCategory;
    }
    
  public String create() {
//      long i = drivingLicenseCategoryFacadeLocal.count()+1;
//      licenseCategory.setId(i);
      drivingLicenseCategoryFacadeLocal.create(licenseCategory);
        return "categoryList";
    }
    
    public String remove() {
        drivingLicenseCategoryFacadeLocal.remove(licenseCategory);
        return "categoryList";
    }
    
    public Collection<DrivingLicenseCategory> getAll() {
        return drivingLicenseCategoryFacadeLocal.findAll();
    }
}
