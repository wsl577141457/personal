package com.longge.controller;

import com.longge.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/askTeaher")
public class AskTeacherController {

    @Autowired
    private IMessageService messageService;

    @PostMapping
    public String sendMessageToTeacher(@RequestBody String messageStr){
        return messageService.sendMessageToTeacher(messageStr);
    }


}
