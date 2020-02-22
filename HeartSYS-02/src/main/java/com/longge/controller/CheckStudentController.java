package com.longge.controller;

import com.longge.pojo.StudentMsg;
import com.longge.service.IMessageService;
import com.longge.service.IStudentMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkStudent")
public class CheckStudentController {

    @Autowired
    private IStudentMsgService studentMsgService;
    @Autowired
    private IMessageService messageService;

    @GetMapping
    public ResponseEntity<List<StudentMsg>> queryStudentByTUsername(String username){
        try {
            List<StudentMsg> studentMsgList = studentMsgService.queryStudentByTUsername(username);
            if(CollectionUtils.isEmpty(studentMsgList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(studentMsgList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping
    public String sentToStudent(@RequestBody String messageStr){
        return messageService.sentToStudent(messageStr);
    }

}
