package ru.rps.lr3.ejb.local.component;

import java.util.List;
import javax.ejb.Local;

import ru.rps.lr3.ejb.local.entity.Account;

@Local
public interface AccountDAOLocal {
    void createSuccess(Account account);
    void createException(Account account);
    void createNonTX(Account account);
    List<Account> getAll();
}
