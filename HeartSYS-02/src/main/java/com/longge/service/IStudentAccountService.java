package com.longge.service;

import com.longge.pojo.AdminAccount;
import com.longge.pojo.StudentAccount;
import com.longge.pojo.TeacherAccount;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IStudentAccountService{
    List<StudentAccount> queryAll();

    void addStudentAccount(StudentAccount studentAccount);

    StudentAccount deleteStudentAccount(String id);

    StudentAccount updateStudentAccount(String studentAccountStr);

    String updateSPassword(String str);

    String findByUserName(String username);
}
