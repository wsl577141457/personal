package com.longge.controller;

import com.longge.pojo.StudentMsg;
import com.longge.service.IStudentMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submitGrade")
public class SubmitGradeController {

    @Autowired
    private IStudentMsgService studentMsgService;

    @PutMapping
    public String submitGrade(@RequestBody String gradeLevel){
            String msg = studentMsgService.submitGrade(gradeLevel);
            return msg;
    }
}
