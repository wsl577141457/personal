package com.longge.controller;

import com.longge.pojo.LevelCount;
import com.longge.service.IStudentMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/count")
public class CountController {

    @Autowired
    private IStudentMsgService studentMsgService;

    @GetMapping
    public ResponseEntity<LevelCount> getCount(){
        try {
            LevelCount levelCount = studentMsgService.getCount();
            return ResponseEntity.ok(levelCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
