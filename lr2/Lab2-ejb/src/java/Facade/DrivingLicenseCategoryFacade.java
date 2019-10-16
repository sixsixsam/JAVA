/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.DrivingLicenseCategory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INFERUS
 */
@Stateless
public class DrivingLicenseCategoryFacade extends AbstractFacade<DrivingLicenseCategory> implements DrivingLicenseCategoryFacadeLocal {

    @PersistenceContext(unitName = "Lab2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DrivingLicenseCategoryFacade() {
        super(DrivingLicenseCategory.class);
    }

    @Override
    public DrivingLicenseCategory findById(Long id) {
        return em.find(DrivingLicenseCategory.class, id);
    }
    
}
