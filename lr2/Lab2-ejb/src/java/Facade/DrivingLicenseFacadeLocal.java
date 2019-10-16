/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.DrivingLicense;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INFERUS
 */
@Local
public interface DrivingLicenseFacadeLocal {

    void create(DrivingLicense drivingLicense);

    void edit(DrivingLicense drivingLicense);

    void remove(DrivingLicense drivingLicense);

    DrivingLicense find(Object id);

    List<DrivingLicense> findAll();
    
    DrivingLicense findById(Long id);    

    List<DrivingLicense> findRange(int[] range);

    int count();
    
}
