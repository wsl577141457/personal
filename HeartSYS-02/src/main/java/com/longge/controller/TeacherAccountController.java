package com.longge.controller;

import com.longge.pojo.TeacherAccount;
import com.longge.service.ITeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacherAccount")
public class TeacherAccountController {

    @Autowired
    private ITeacherAccountService teacherAccountService;

    @GetMapping
    public ResponseEntity<List<TeacherAccount>> queryAll(){
        try {
            List<TeacherAccount> teacherAccountList = teacherAccountService.queryAll();
            if(CollectionUtils.isEmpty(teacherAccountList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(teacherAccountList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping
    public ResponseEntity<TeacherAccount> addTeacherAccount(@RequestBody String teacherAccountStr){
        try {
            TeacherAccount teacherAccount = teacherAccountService.addTeacherAccount(teacherAccountStr);
            return ResponseEntity.ok(teacherAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeacherAccount> deleteTeacherAccount(@PathVariable String id){
        try {
            TeacherAccount teacherAccount = teacherAccountService.deleteTeacherAccount(id);
            return ResponseEntity.ok(teacherAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping
    public ResponseEntity<TeacherAccount> updateTeacherAccount(@RequestBody String teacherAccountStr){
        try {
            TeacherAccount teacherAccount = teacherAccountService.updateTeacherAccount(teacherAccountStr);
            return ResponseEntity.ok(teacherAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/1")
    public String findByUserName(String username){
        return teacherAccountService.findByUserName(username);
    }
}
