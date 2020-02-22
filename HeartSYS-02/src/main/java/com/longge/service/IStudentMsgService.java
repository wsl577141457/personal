package com.longge.service;

import com.longge.pojo.LevelCount;
import com.longge.pojo.StudentMsg;

import java.util.List;

public interface IStudentMsgService {
    String ifChooset(String usernameStr);

    List<StudentMsg> queryStudentByTUsername(String usernameStr);

    LevelCount getCount();

    String submitGrade(String gradeLevel);
}
