/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.DrivingLicenseCategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface DrivingLicenseCategoryFacadeLocal {

    void create(DrivingLicenseCategory drivingLicenseCategory);

    void edit(DrivingLicenseCategory drivingLicenseCategory);

    void remove(DrivingLicenseCategory drivingLicenseCategory);

    DrivingLicenseCategory find(Object id);

    List<DrivingLicenseCategory> findAll();
    
    DrivingLicenseCategory findById(Long id);
    
    List<DrivingLicenseCategory> findRange(int[] range);

    int count();
    
}
