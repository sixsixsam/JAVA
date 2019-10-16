package ru.rps.lr1.web.mb;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ru.rps.lr1.ejb.component.LoginUtilsLocal;
import ru.rps.lr1.web.component.SessionStateLocal;

@Named("login")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private SessionStateLocal sessionState;
    @EJB
    private LoginUtilsLocal loginUtils;

    private String login;
    private String password;

    private String error;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getError() {
        return error;
    }

    public String start() {
        if(sessionState.isLoggedIn()) {
            return "chat?faces-redirect=true";
        }
        if(loginUtils.checkCredentials(login, password)) {
            sessionState.setCurrentUser(login);
            return "chat?faces-redirect=true";
        }
        error = "Неверный логин или пароль";
        return "index";
    }

    public String currentUser() {
        return sessionState.getCurrentUser();
    }
}
