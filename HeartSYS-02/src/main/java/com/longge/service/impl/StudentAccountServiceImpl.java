package com.longge.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.dao.StudentAccountDao;
import com.longge.pojo.AdminAccount;
import com.longge.pojo.StudentAccount;
import com.longge.pojo.TeacherAccount;
import com.longge.service.IStudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAccountServiceImpl implements IStudentAccountService{

    @Autowired
    private StudentAccountDao dao;

    @Override
    public List<StudentAccount> queryAll() {
        return dao.selectAll();
    }

    @Override
    public void addStudentAccount(StudentAccount studentAccount) {
        dao.insertSelective(studentAccount);
    }

    @Override
    public StudentAccount deleteStudentAccount(String id) {
        StudentAccount studentAccount = new StudentAccount();
        studentAccount.setId(Integer.parseInt(id));
        dao.deleteByPrimaryKey(studentAccount);
        return studentAccount;
    }

    @Override
    public StudentAccount updateStudentAccount(String studentAccountStr) {
        studentAccountStr = studentAccountStr.substring(1,studentAccountStr.length()-1);
        studentAccountStr = studentAccountStr.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(studentAccountStr);
        StudentAccount studentAccount = JSON.toJavaObject(jsonObject,StudentAccount.class);
        dao.updateByPrimaryKeySelective(studentAccount);
        return studentAccount;
    }

    @Override
    public String updateSPassword(String str) {
        str = str.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(str);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        dao.updatePassword(username,password);
        return "成功";
    }

    @Override
    public String findByUserName(String username) {
        return dao.findByUsername(username).getName();
    }

}
