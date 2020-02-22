package com.longge.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.dao.StudentAccountDao;
import com.longge.dao.TeacherAccountDao;
import com.longge.dao.ToStudentDao;
import com.longge.dao.ToTeacherDao;
import com.longge.pojo.ToStudentMsg;
import com.longge.pojo.ToTeacherMsg;
import com.longge.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private ToStudentDao toStudentDao;
    @Autowired
    private ToTeacherDao toTeacherDao;
    @Autowired
    private StudentAccountDao studentAccountDao;
    @Autowired
    private TeacherAccountDao teacherAccountDao;

    @Override
    public String sendMessageToTeacher(String messageStr) {
        messageStr = messageStr.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(messageStr);
        String username = jsonObject.getString("username");
        String message = jsonObject.getString("message");
        Integer tid = Integer.parseInt(jsonObject.getString("tid"));
        Integer sid = studentAccountDao.findByUsername(username).getId();
        toTeacherDao.sendMessageToTeacher(tid,sid,message);
        return "成功";
    }

    @Override
    public String sentToStudent(String messageStr) {
        messageStr = messageStr.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(messageStr);
        String tname = jsonObject.getString("tname");
        String sname = jsonObject.getString("sname");
        String message = jsonObject.getString("message");
        Integer tid = teacherAccountDao.findByUsername(tname).getId();
        Integer sid = studentAccountDao.findByUsername(sname).getId();
        toStudentDao.sentToStudent(sid,tid,message);
        return "成功";
    }

    @Override
    public List<ToStudentMsg> getStudentmsg(String username) {
        Integer sid = studentAccountDao.findByUsername(username).getId();
        List<ToStudentMsg> toStudentMsgList = toStudentDao.getStudentmsg(sid);
        return toStudentMsgList;
    }

    @Override
    public List<ToTeacherMsg> getTeachermsg(String username) {
        Integer tid = teacherAccountDao.findByUsername(username).getId();
        List<ToTeacherMsg> toTeacherMsgList = toTeacherDao.getTeachermsg(tid);
        return toTeacherMsgList;
    }

    @Override
    @Transactional
    public String deleteStudentmsg(Integer id) {
        ToStudentMsg studentMsg = new ToStudentMsg();
        studentMsg.setId(id);
        int i = toStudentDao.deleteByPrimaryKey(studentMsg);
        return String.valueOf(i);
    }

    @Override
    @Transactional
    public String deleteTeachermsg(Integer id) {
        ToTeacherMsg teacherMsg = new ToTeacherMsg();
        teacherMsg.setId(id);
        toTeacherDao.deleteByPrimaryKey(teacherMsg);
        return "成功";
    }

}
