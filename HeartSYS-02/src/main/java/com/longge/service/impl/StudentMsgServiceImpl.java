package com.longge.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.longge.dao.StudentAccountDao;
import com.longge.dao.StudentMsgDao;
import com.longge.dao.TeacherAccountDao;
import com.longge.pojo.LevelCount;
import com.longge.pojo.StudentAccount;
import com.longge.pojo.StudentMsg;
import com.longge.service.IStudentMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class StudentMsgServiceImpl implements IStudentMsgService {

    @Autowired
    private StudentAccountDao dao1;

    @Autowired
    private StudentMsgDao dao2;

    @Autowired
    private TeacherAccountDao teacherAccountDao;

    @Override
    public String ifChooset(String usernameStr) {
        usernameStr = usernameStr.substring(1,usernameStr.length()-1);
        usernameStr = usernameStr.replace("\\\'","\'");
        JSONObject jsonObject = JSONObject.parseObject(usernameStr);
        String username = jsonObject.getString("username");
        StudentAccount studentAccount = dao1.findByUsername(username);
        Integer sid = studentAccount.getId();
        if (dao2.findTidBySid(sid) == null){
            return "请先选择老师分组！";
        }
        return "通过";
    }


    @Override
    public List<StudentMsg> queryStudentByTUsername(String username) {

        Integer tid = teacherAccountDao.findByUsername(username).getId();
        List<StudentMsg> studentMsgList = dao2.findStudentMsgByTId(tid);
        return studentMsgList;
    }

    @Override
    public LevelCount getCount() {
        LevelCount levelCount = new LevelCount();
        levelCount.setA(dao2.countA());
        levelCount.setB(dao2.countB());
        levelCount.setC(dao2.countC());
        levelCount.setD(dao2.countD());
        return levelCount;
    }

    @Override
    public String submitGrade(String gradeLevel) {
        try {
            gradeLevel = gradeLevel.replace("\\\"","\"");
            JSONObject jsonObject = JSONObject.parseObject(gradeLevel);
            Integer grade = Integer.parseInt(jsonObject.getString("grade"));
            Integer level = Integer.parseInt(jsonObject.getString("level"));
            String username = jsonObject.getString("username");
            Integer accountId = dao1.findByUsername(username).getId();
            dao2.submitGrade(accountId,grade,level);
            return String.valueOf(level);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "插入成绩失败";
    }
}
