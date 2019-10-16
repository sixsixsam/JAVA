package ru.rps.lr1.ejb.component;

import javax.ejb.Stateless;

@Stateless
public class LoginUtils implements LoginUtilsLocal {
    @Override
    public boolean checkCredentials(String login, String password) {
        return login.equals("user") && password.equals("password");
    }
}
