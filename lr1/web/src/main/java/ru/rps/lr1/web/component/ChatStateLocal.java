package ru.rps.lr1.web.component;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ChatStateLocal {
    void start();
    void save(String message);
    List<String> history();
    void stop();
}
