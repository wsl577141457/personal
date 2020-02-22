package com.longge.controller;

import com.longge.pojo.TeacherGroup;
import com.longge.service.ITeacherGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/joinGroup")
public class JoinGroupController {

    @Autowired
    private ITeacherGService service;

    @PutMapping
    public String join(@RequestBody String joinStr){
        String returnMsg = service.join(joinStr);
        return returnMsg;
    }

}
