package com.longge.dao;

import com.longge.pojo.StudentMsg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface StudentMsgDao extends Mapper<StudentMsg> {

    @Update("update tb_studentmsg set teacherId = #{tid} where accountId = #{sid}")
    void addGroup(@Param("tid") Integer tid,@Param("sid") Integer sid);

    @Select("select teacherId from tb_studentmsg where accountId = #{sid}")
    Integer findTidBySid(Integer sid);

    @Select("select grade from tb_studentmsg where accountId = #{sid}")
    Integer findGradeBySid(Integer sid);

    @Select("select level from tb_studentmsg where accountId = #{sid}")
    Integer findLevelBySid(Integer sid);

    @Select("select * from tb_studentmsg where teacherId = #{tid}")
    List<StudentMsg> findStudentMsgByTId(Integer tid);

    @Select("select count(level) from tb_studentmsg where level = 2")
    Integer countB();

    @Select("select count(level) from tb_studentmsg where level = 3")
    Integer countC();

    @Select("select count(level) from tb_studentmsg where level = 4")
    Integer countD();

    @Select("select count(level) from tb_studentmsg where level = 1")
    Integer countA();

    @Update("update tb_studentmsg set grade = #{grade} , level = #{level} where accountId = #{accountId} ")
    void submitGrade(@Param("accountId") Integer accountId,@Param("grade") Integer grade,@Param("level") Integer level);
}
