package com.longge.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.dao.TeacherAccountDao;
import com.longge.pojo.TeacherAccount;
import com.longge.service.ITeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherAccountServiceImpl implements ITeacherAccountService {

    @Autowired
    private TeacherAccountDao dao;

    @Override
    public List<TeacherAccount> queryAll() {
        return dao.selectAll();
    }

    @Override
    public TeacherAccount addTeacherAccount(String teacherAccountStr) {
        teacherAccountStr = teacherAccountStr.substring(1,teacherAccountStr.length()-1);
        teacherAccountStr = teacherAccountStr.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(teacherAccountStr);
        TeacherAccount teacherAccount = JSON.toJavaObject(jsonObject,TeacherAccount.class);
        dao.insertSelective(teacherAccount);
        return teacherAccount;
    }

    @Override
    public TeacherAccount deleteTeacherAccount(String id) {
        TeacherAccount teacherAccount = new TeacherAccount();
        teacherAccount.setId(Integer.parseInt(id));
        dao.deleteByPrimaryKey(teacherAccount);
        return teacherAccount;
    }

    @Override
    public TeacherAccount updateTeacherAccount(String teacherAccountStr) {
        teacherAccountStr = teacherAccountStr.substring(1,teacherAccountStr.length()-1);
        teacherAccountStr = teacherAccountStr.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(teacherAccountStr);
        TeacherAccount teacherAccount = JSON.toJavaObject(jsonObject,TeacherAccount.class);
        dao.updateByPrimaryKeySelective(teacherAccount);
        return teacherAccount;
    }

    @Override
    public String updateTPassword(String str) {
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
