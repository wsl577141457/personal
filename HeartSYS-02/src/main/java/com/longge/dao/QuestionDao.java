package com.longge.dao;

import com.longge.pojo.Question;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface QuestionDao extends Mapper<Question> {

    @Select("select * from tb_questions order by rand() limit 10")
    List<Question> findQuestionsToTest();
}
