package com.longge.service;

import com.longge.pojo.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> findQuestionsToTest();

    List<Question> queryAll();

    void addQuestion(Question question);

    void deleteQuestion(String id);

    void updateQuestion(Question question);
}
