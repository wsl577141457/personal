package com.longge.domain;

import java.util.HashSet;
import java.util.Set;

//一对多练习。客户
public class Customer {
    private Integer id;
    private String name;
    //hibernate规定用set表示多的那一边
    private Set<LinkMan> linkManSet = new HashSet<>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LinkMan> getLinkManSet() {
        return linkManSet;
    }

    public void setLinkManSet(Set<LinkMan> linkManSet) {
        this.linkManSet = linkManSet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", linkManSet=" + linkManSet +
                '}';
    }
}
