package com.longge.service.impl;

import com.longge.dao.QuestionDao;
import com.longge.pojo.Question;
import com.longge.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionDao dao;

    @Override
    public List<Question> findQuestionsToTest() {
        return dao.findQuestionsToTest();
    }

    @Override
    public List<Question> queryAll() {
        return dao.selectAll();
    }

    @Override
    public void addQuestion(Question question) {
        dao.insert(question);
    }

    @Override
    public void deleteQuestion(String id) {
        Question question = new Question();
        question.setId(Integer.parseInt(id));
        dao.delete(question);
    }

    @Override
    public void updateQuestion(Question question) {
        dao.updateByPrimaryKeySelective(question);
    }
}
