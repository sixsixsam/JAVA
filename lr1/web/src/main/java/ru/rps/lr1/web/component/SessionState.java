package ru.rps.lr1.web.component;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ru.rps.lr1.ejb.component.Application;

@SessionScoped
@Stateful
public class SessionState implements SessionStateLocal, Serializable {

    @EJB
    private Application application;

    private String currentUserName;
    private boolean loggedIn;

    @PostConstruct
    private void postConstructMethod() {
        application.addSession();
    }

    @Override
    public void setCurrentUser(String userName) {
        currentUserName = userName;
        loggedIn = true;
    }

    @Override
    public String getCurrentUser() {
        return currentUserName;
    }

    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }
}
