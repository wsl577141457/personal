package com.longge.pojo;

import javax.persistence.*;

@Table(name = "tb_student")
public class StudentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer role;
    @Transient
    private String roleStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getRoleStr() {
        return "学生";
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }


    @Override
    public String toString() {
        return "StudentAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", roleStr='" + roleStr + '\'' +
                '}';
    }
}
