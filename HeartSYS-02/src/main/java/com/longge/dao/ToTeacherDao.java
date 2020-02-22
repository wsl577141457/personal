package com.longge.dao;

import com.longge.pojo.ToTeacherMsg;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ToTeacherDao extends Mapper<ToTeacherMsg> {

    @Insert("insert into tb_toteachermsg(tid,sid,message) values(#{tid},#{sid},#{message})")
    void sendMessageToTeacher(@Param("tid") Integer tid,@Param("sid") Integer sid,@Param("message") String message);

    @Select("select * from tb_toteachermsg where tid = #{tid}")
    @Results(id = "aaa",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "message",property = "message"),
            @Result(column = "tid",property = "teacherAccount",one = @One(select = "com.longge.dao.TeacherAccountDao.findById")),
            @Result(column = "sid",property = "studentAccount",one = @One(select = "com.longge.dao.StudentAccountDao.findById"))
    })
    List<ToTeacherMsg> getTeachermsg(Integer tid);

}
