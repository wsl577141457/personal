package com.longge.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.dao.StudentAccountDao;
import com.longge.dao.StudentMsgDao;
import com.longge.dao.TeacherGDao;
import com.longge.pojo.StudentAccount;
import com.longge.pojo.StudentMsg;
import com.longge.pojo.TeacherGroup;
import com.longge.service.ITeacherGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherGServiceImpl implements ITeacherGService {
    @Autowired
    private TeacherGDao dao;
    @Autowired
    private StudentAccountDao studentAccountDao;
    @Autowired
    private StudentMsgDao studentMsgDao;

    @Override
    public List<TeacherGroup> queryAll() {
        return dao.queryGAndA();
    }

    @Override
    public TeacherGroup saveTeacherGroup(String teacherGroupStr) {
        teacherGroupStr = teacherGroupStr.substring(1,teacherGroupStr.length()-1);
        teacherGroupStr = teacherGroupStr.replace("\\\"","\"");
        String tid = teacherGroupStr.substring(7,teacherGroupStr.indexOf(",")).substring(1,teacherGroupStr.substring(7,teacherGroupStr.indexOf(",")).length()-1);
        teacherGroupStr = teacherGroupStr.replace(teacherGroupStr.substring(0,teacherGroupStr.indexOf(",")+1),"{");
        JSONObject jsonObject = JSONObject.parseObject(teacherGroupStr);
        TeacherGroup teacherGroup = JSON.toJavaObject(jsonObject,TeacherGroup.class);
        dao.saveTeacherGroup(teacherGroup,tid);
        return teacherGroup;
    }

    @Override
    public void deleteTeacherGroup(String gid) {
        TeacherGroup teacherGroup = new TeacherGroup();
        teacherGroup.setId(Integer.parseInt(gid));
        dao.deleteByPrimaryKey(teacherGroup);
    }

    @Override
    public void updateTeacherGroup(String teacherGroupStr){
        teacherGroupStr = teacherGroupStr.substring(1,teacherGroupStr.length()-1);
        teacherGroupStr = teacherGroupStr.replace("\\\"","\"");
        JSONObject jsonObject = JSONObject.parseObject(teacherGroupStr);
        TeacherGroup teacherGroup = JSON.toJavaObject(jsonObject,TeacherGroup.class);
        dao.updateByPrimaryKeySelective(teacherGroup);
    }

    @Override
    public String join(String joinStr){
        try {
            joinStr = joinStr.substring(1,joinStr.length()-1);
            joinStr = joinStr.replace("\\\"","\"");
            JSONObject jsonObject = JSONObject.parseObject(joinStr);
            String idStr = jsonObject.getString("id");
            String username = jsonObject.getString("username");
            Integer gid = Integer.parseInt(idStr);
            StudentAccount sa = studentAccountDao.findByUsername(username);
            Integer sid = sa.getId();
            Integer testTid = studentMsgDao.findTidBySid(sid);
            if(testTid != null){
                return "你已经选择了分组！";
            }
            TeacherGroup teacherGroup = dao.selectById(gid);
            if(teacherGroup.getChooseNum() > teacherGroup.getMaxNum() || teacherGroup.getChooseNum() == teacherGroup.getMaxNum()){
                return "该老师分组人数已满！";
            }
            Integer tid = teacherGroup.getTeacherAccount().getId();
            dao.addStudent(gid);
            studentMsgDao.addGroup(tid,sid);
            return "加入分组成功！";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "目前选择该分组的人数较多，请稍后再试！";
    }
}
