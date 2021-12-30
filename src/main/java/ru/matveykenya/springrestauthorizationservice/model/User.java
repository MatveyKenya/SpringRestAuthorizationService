package ru.matveykenya.springrestauthorizationservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private String password;
    private Set<Authorities> authoritiesList;

    public User(String name, String password, Set<Authorities> authoritiesList) {
        this.name = name;
        this.password = password;
        this.authoritiesList = authoritiesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAuthoritiesList() {
        return new ArrayList<>(authoritiesList);
    }

    public void setAuthoritiesList(Set<Authorities> authoritiesList) {
        this.authoritiesList = authoritiesList;
    }
}
