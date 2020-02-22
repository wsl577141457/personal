package com.longge.service;

import com.longge.pojo.TeacherAccount;

import java.util.List;

public interface ITeacherAccountService {
    List<TeacherAccount> queryAll();

    TeacherAccount addTeacherAccount(String teacherAccountStr);

    TeacherAccount deleteTeacherAccount(String id);

    TeacherAccount updateTeacherAccount(String teacherAccountStr);

    String updateTPassword(String str);

    String findByUserName(String username);
}
