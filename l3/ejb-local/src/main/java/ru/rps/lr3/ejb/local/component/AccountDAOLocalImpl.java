package ru.rps.lr3.ejb.local.component;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import ru.rps.lr3.ejb.local.entity.Account;

@Stateless
public class AccountDAOLocalImpl implements AccountDAOLocal {

    @PersistenceContext(unitName = "transactAccount")
    private EntityManager em;

    @Override
    public void createSuccess(Account account) {
        em.persist(account);
    }

    @Override
    public void createException(Account account) throws EJBException {
        em.persist(account);
        throw new EJBException();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void createNonTX(Account account) {
        em.persist(account);
    }

    @Override
    public List<Account> getAll() {
        return em.createQuery("select a from Account a", Account.class).getResultList();
    }
}
