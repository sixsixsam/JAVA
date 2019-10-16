package ru.rps.lr3.web.component;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import ru.rps.lr3.ejb.local.component.AccountDAOLocal;
import ru.rps.lr3.ejb.local.entity.Account;
import ru.rps.lr3.ejb.remote.client.PersonDAORemote;
import ru.rps.lr3.ejb.remote.entity.Person;

@LocalBean
@Stateless
public class Experiments {
    @EJB
    private PersonDAORemote personDAO;
    @EJB
    private AccountDAOLocal accountDAO;

    @Transactional
    public void commitBoth(Person person, Account account) {
        personDAO.createSuccess(person);
        accountDAO.createSuccess(account);
    }

    @Transactional
    public void rollbackFirst(Person person, Account account) {
        personDAO.createRollback(person);
        accountDAO.createSuccess(account);
    }

    @Transactional
    public void exceptionSecond(Person person, Account account) {
        personDAO.createSuccess(person);
        accountDAO.createException(account);
    }

    @Transactional
    public void rollbackFirstNonTXSecond(Person person, Account account) {
        accountDAO.createNonTX(account);
        personDAO.createRollback(person);
    }

    @Transactional
    public void newTXFirstExceptionSecond(Person person, Account account) {
        personDAO.createNewTX(person);
        accountDAO.createException(account);
    }

    public List<Account> getAccounts() {
        return accountDAO.getAll();
    }

    public List<Person> getPersons() {
        return personDAO.getAll();
    }
}
