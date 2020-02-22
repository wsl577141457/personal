package com.longge.controller;

import com.longge.service.IStudentMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentMsg")
public class StudentMsgController {

    @Autowired
    private IStudentMsgService service;

    @PostMapping("/ifChooset")
    public String ifChooset(@RequestBody String usernameStr){
        return service.ifChooset(usernameStr);
    }

}
