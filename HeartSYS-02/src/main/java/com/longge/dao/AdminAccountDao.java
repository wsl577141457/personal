package com.longge.dao;

import com.longge.pojo.AdminAccount;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface AdminAccountDao extends Mapper<AdminAccount> {
    @Select("select * from tb_admin where username = #{username}")
    AdminAccount findByUsername(String username);
}
