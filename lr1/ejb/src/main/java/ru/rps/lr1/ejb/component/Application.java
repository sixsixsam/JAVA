package ru.rps.lr1.ejb.component;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;

@LocalBean
@Named("applicationBean")
@Singleton
public class Application {
    private int sessionsCount;

    public void addSession() {
        sessionsCount++;
    }

    public int getSessionsCount() {
        return sessionsCount;
    }
}
