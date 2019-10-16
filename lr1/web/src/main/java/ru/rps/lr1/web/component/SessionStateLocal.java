package ru.rps.lr1.web.component;

import javax.ejb.Local;

/**
 * @author mobrubov
 * Created on 01.04.19
 */
@Local
public interface SessionStateLocal {
    void setCurrentUser(String userName);
    String getCurrentUser();
    boolean isLoggedIn();
}
