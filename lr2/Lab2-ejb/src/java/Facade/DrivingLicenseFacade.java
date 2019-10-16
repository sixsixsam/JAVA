/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.DrivingLicense;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INFERUS
 */
@Stateless
public class DrivingLicenseFacade extends AbstractFacade<DrivingLicense> implements DrivingLicenseFacadeLocal {

    @PersistenceContext(unitName = "Lab2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DrivingLicenseFacade() {
        super(DrivingLicense.class);
    }
    
    @Override
    public DrivingLicense findById(Long id) {
        return em.find(DrivingLicense.class, id);
    }
    
}
