package com.longge.dao;

import com.longge.pojo.StudentAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface StudentAccountDao extends Mapper<StudentAccount> {
    @Select("select * from tb_student where username = #{username}")
    StudentAccount findByUsername(String username);

    @Select("select * from tb_student where id = #{id}")
    StudentAccount findById(Integer id);

    @Update("update tb_student set password = #{password} where username = #{username}")
    void updatePassword(@Param("username") String username,@Param("password") String password);
}
