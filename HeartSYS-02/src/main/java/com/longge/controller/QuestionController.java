package com.longge.controller;

import com.longge.pojo.Question;
import com.longge.service.IQuestionService;
import com.longge.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> findQuestionsToTest(){
        try {
            List<Question> questionList = questionService.findQuestionsToTest();
            if (CollectionUtils.isEmpty(questionList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(questionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
