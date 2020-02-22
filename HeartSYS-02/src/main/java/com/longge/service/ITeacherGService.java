package com.longge.service;

import com.longge.pojo.TeacherGroup;

import java.util.List;

public interface ITeacherGService {
    List<TeacherGroup> queryAll();

    TeacherGroup saveTeacherGroup(String teacherGroupStr);

    void deleteTeacherGroup(String gid);

    void updateTeacherGroup(String teacherGroupStr);

    String join(String joinStr);
}
