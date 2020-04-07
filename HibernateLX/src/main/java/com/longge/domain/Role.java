package com.longge.domain;

import java.util.HashSet;
import java.util.Set;

//多对多练习，角色
public class Role {
    private Integer id;
    private String role;
    private Set<Account> accounts = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
