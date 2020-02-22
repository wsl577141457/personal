package com.longge.service;

import com.longge.pojo.ToStudentMsg;
import com.longge.pojo.ToTeacherMsg;

import java.util.List;

public interface IMessageService {
    String sendMessageToTeacher(String messageStr);

    String sentToStudent(String messageStr);

    List<ToStudentMsg> getStudentmsg(String username);

    List<ToTeacherMsg> getTeachermsg(String username);

    String deleteStudentmsg(Integer id);

    String deleteTeachermsg(Integer id);

}
