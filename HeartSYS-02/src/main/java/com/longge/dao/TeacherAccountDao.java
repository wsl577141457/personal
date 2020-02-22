package com.longge.dao;

import com.longge.pojo.TeacherAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface TeacherAccountDao extends Mapper<TeacherAccount> {
    @Select("select * from tb_teacher where id = #{id}")
    public TeacherAccount findById(Integer id);
    @Select("select * from tb_teacher where username = #{username}")
    TeacherAccount findByUsername(String username);

    @Update("update tb_teacher set password = #{password} where username = #{username}")
    void updatePassword(@Param("username") String username,@Param("password") String password);
}
