package ru.rps.lr3.web.mb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ru.rps.lr3.ejb.remote.entity.Person;
import ru.rps.lr3.ejb.local.entity.Account;
import ru.rps.lr3.web.component.Experiments;

@Named("experiment")
@RequestScoped
public class ExperimentController implements Serializable {

    @EJB
    private Experiments experiments;

    public String commitBoth() {
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        person.setBirthDate(new Date());
//        Person person = new Person("Ivan", "Ivanov", new Date());
        Account account = new Account("vanya", "123", "VK");
        experiments.commitBoth(person, account);
        return "index";
    }

    public String rollbackFirst() {
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        person.setBirthDate(new Date());

        //Person person = new Person("Petr", "Petrov", new Date());
        Account account = new Account("petya", "123", "FACEBOOK");
        experiments.rollbackFirst(person, account);
        return "index";
    }

    public String exceptionSecond() {
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        person.setBirthDate(new Date());

        //Person person = new Person("Sergey", "Sergeev", new Date());
        Account account = new Account("sereja", "123", "TWITTER");
        experiments.exceptionSecond(person, account);
        return "index";
    }

    public String rollbackFirstNonTXSecond() {
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        person.setBirthDate(new Date());

        //Person person = new Person("Alexey", "Alexeev", new Date());
        Account account = new Account("lexa", "123", "GOOGLE");
        experiments.rollbackFirstNonTXSecond(person, account);
        return "index";
    }

    public String newTXFirstExceptionSecond() {
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Ivanov");
        person.setBirthDate(new Date());

        //Person person = new Person("Andrey", "Andreev", new Date());
        Account account = new Account("andrew", "123", "MAIL");
        experiments.newTXFirstExceptionSecond(person, account);
        return "index";
    }

    public List<Account> getAccounts() {
        return experiments.getAccounts();
    }

    public List<Person> getPersons() {
        return experiments.getPersons();
    }
}
