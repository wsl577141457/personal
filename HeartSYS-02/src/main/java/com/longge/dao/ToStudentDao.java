package com.longge.dao;

import com.longge.pojo.ToStudentMsg;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ToStudentDao extends Mapper<ToStudentMsg> {
    @Insert("insert into tb_tostudentmsg(tid,sid,message) values(#{tid},#{sid},#{message})")
    void sentToStudent(@Param("sid") Integer sid,@Param("tid") Integer tid,@Param("message") String message);

    @Select("select * from tb_tostudentmsg where sid = #{sid}")
    @Results(id = "aaa",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "message",property = "message"),
            @Result(column = "tid",property = "teacherAccount",one = @One(select = "com.longge.dao.TeacherAccountDao.findById")),
            @Result(column = "sid",property = "studentAccount",one = @One(select = "com.longge.dao.StudentAccountDao.findById"))
    })
    List<ToStudentMsg> getStudentmsg(Integer sid);

}
