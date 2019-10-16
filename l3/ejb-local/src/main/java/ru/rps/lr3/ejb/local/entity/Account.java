package ru.rps.lr3.ejb.local.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String service;

    public Account() {
    }

    public Account(String login, String password, String service) {
        this.login = login;
        this.password = password;
        this.service = service;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) &&
            Objects.equals(getLogin(), account.getLogin()) &&
            Objects.equals(getPassword(), account.getPassword()) &&
            Objects.equals(getService(), account.getService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getService());
    }

    @Override
    public String toString() {
        return "id=" + id + ", login=" + login + ", password=" + password + ", service=" + service;
    }
}
