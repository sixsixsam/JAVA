package ru.rps.lr3.ejb.remote.client;

import java.util.List;

import javax.ejb.Remote;

import ru.rps.lr3.ejb.remote.entity.Person;

@Remote
public interface PersonDAORemote {
    void createSuccess(Person person);
    void createRollback(Person person);
    void createNewTX(Person person);
    List<Person> getAll();
}
