/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.EJB;
import Facade.*;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import Entity.*;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author INFERUS
 */
@Named("personBean")
@RequestScoped
public class PersonBean implements Serializable {

    @EJB
    PersonFacadeLocal personFacadeLocal;
    @EJB
    DrivingLicenseFacadeLocal drivingLicenseFacadeLocal;

    public PersonBean() {
        person = new Person();
    }

    private Person person;

    private Long selectedDrivingLicense;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getSelectedDrivingLicense() {
        return selectedDrivingLicense;
    }

    public void setSelectedDrivingLicense(Long selectedDrivingLicense) {
        this.selectedDrivingLicense = selectedDrivingLicense;
    }

    public String create() {
//        long i = personFacadeLocal.count() + 1;
//        person.setId(i);
        person.setDrivingLicenseId(drivingLicenseFacadeLocal.findById(selectedDrivingLicense));
        personFacadeLocal.create(person);
        return "personList";
    }

    public String remove() {
        person = personFacadeLocal.findById(person.getId());
        personFacadeLocal.remove(person);
        return "personList";
    }

    public Collection<Person> getAll() {
        return personFacadeLocal.findAll();
    }

}
