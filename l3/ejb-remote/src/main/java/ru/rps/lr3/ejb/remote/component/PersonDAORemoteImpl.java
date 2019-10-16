package ru.rps.lr3.ejb.remote.component;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ru.rps.lr3.ejb.remote.client.PersonDAORemote;
import ru.rps.lr3.ejb.remote.entity.Person;

@Stateless
public class PersonDAORemoteImpl implements PersonDAORemote {

    @PersistenceContext(unitName = "transactPerson")
    private EntityManager em;

    @Resource
    private SessionContext sessionContext;

    @Override
    public void createSuccess(Person person) {
        em.persist(person);
    }

    @Override
    public void createRollback(Person person) {
        em.persist(person);
        sessionContext.setRollbackOnly();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createNewTX(Person person) {
        em.persist(person);
    }

    @Override
    public List<Person> getAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }
}
