package ru.rps.lr1.ejb.component;

import javax.ejb.Local;

@Local
public interface LoginUtilsLocal {
    boolean checkCredentials(String login, String password);
}
