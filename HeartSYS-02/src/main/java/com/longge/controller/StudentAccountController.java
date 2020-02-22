package com.longge.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.longge.pojo.StudentAccount;
import com.longge.service.IStudentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/studentAccount")
public class StudentAccountController {

    @Autowired
    private IStudentAccountService studentAccountService;

    @GetMapping
    public ResponseEntity<List<StudentAccount>> queryAll(){
        try {
            List<StudentAccount> studentAccountList = studentAccountService.queryAll();
            if(CollectionUtils.isEmpty(studentAccountList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(studentAccountList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping
    public ResponseEntity<StudentAccount> addStudentAccount(@RequestBody String studentAccountStr){
        try {
            studentAccountStr = studentAccountStr.substring(1,studentAccountStr.length()-1);
            studentAccountStr = studentAccountStr.replace("\\\"","\"");
            JSONObject jsonObject = JSONObject.parseObject(studentAccountStr);
            StudentAccount studentAccount = JSON.toJavaObject(jsonObject,StudentAccount.class);
            studentAccountService.addStudentAccount(studentAccount);
            return ResponseEntity.ok(studentAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentAccount> deleteStudentAccount(@PathVariable String id){
        try {
            StudentAccount studentAccount = studentAccountService.deleteStudentAccount(id);
            return ResponseEntity.ok(studentAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping()
    public ResponseEntity<StudentAccount> updateStudentAccount(@RequestBody String studentAccountStr){
        try {
            StudentAccount studentAccount = studentAccountService.updateStudentAccount(studentAccountStr);
            return ResponseEntity.ok(studentAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/1")
    public String findByUserName(String username){
        return studentAccountService.findByUserName(username);
    }

}
