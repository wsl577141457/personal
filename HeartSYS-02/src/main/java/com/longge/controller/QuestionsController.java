package com.longge.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.pojo.Question;
import com.longge.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private IQuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> queryAll(){
        try {
            List<Question> questionList = questionService.queryAll();
            if(CollectionUtils.isEmpty(questionList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(questionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody String questionStr){
        try {
            questionStr = questionStr.substring(1,questionStr.length()-1);
            questionStr = questionStr.replace("\\\"","\"");
            JSONObject json = JSONObject.parseObject(questionStr);
            Question question = JSON.toJavaObject(json,Question.class);
            questionService.addQuestion(question);
            return ResponseEntity.ok(question);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String id){
        try {
            questionService.deleteQuestion(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping
    public ResponseEntity<Question> updateQuestion(@RequestBody String questionStr){
        try {
            questionStr = questionStr.substring(1,questionStr.length()-1);
            questionStr = questionStr.replace("\\\"","\"");
            JSONObject json = JSONObject.parseObject(questionStr);
            Question question = JSON.toJavaObject(json,Question.class);
            questionService.updateQuestion(question);
            return ResponseEntity.ok(question);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
