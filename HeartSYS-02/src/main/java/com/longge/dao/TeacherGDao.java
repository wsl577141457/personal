package com.longge.dao;

import com.longge.pojo.TeacherGroup;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface TeacherGDao extends Mapper<TeacherGroup> {

    @Select("select * from tb_teachergroup")
    @Results(id = "teacherGMap",value = {
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "maxNum",property = "maxNum"),
        @Result(column = "chooseNum",property = "chooseNum"),
        @Result(column = "full",property = "full"),
        @Result(column = "teacher_id",property = "teacherAccount",one = @One(select = "com.longge.dao.TeacherAccountDao.findById"))
    })
    public List<TeacherGroup> queryGAndA();

    @Insert("insert into tb_teachergroup(maxNum,teacher_id) values(#{teacherGroup.maxNum},#{tid}) ")
    public void saveTeacherGroup(@Param("teacherGroup") TeacherGroup teacherGroup, @Param("tid") String tid);

    @Update("update tb_teachergroup set chooseNum = chooseNum + 1 where id = #{id}")
    void addStudent(Integer id);

    @Select("select * from tb_teachergroup where id = #{id}")
    @Results(id = "teacherGMap2",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "maxNum",property = "maxNum"),
            @Result(column = "chooseNum",property = "chooseNum"),
            @Result(column = "full",property = "full"),
            @Result(column = "teacher_id",property = "teacherAccount",one = @One(select = "com.longge.dao.TeacherAccountDao.findById"))
    })
    TeacherGroup selectById(Integer id);
}
