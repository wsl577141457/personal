package com.longge.controller;

import com.longge.pojo.ToStudentMsg;
import com.longge.pojo.ToTeacherMsg;
import com.longge.service.IMessageService;
import com.longge.service.IStudentAccountService;
import com.longge.service.ITeacherAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mainMethor")
public class MainController {

    @Autowired
    private IMessageService messageService;
    @Autowired
    private IStudentAccountService studentAccountService;
    @Autowired
    private ITeacherAccountService teacherAccountService;

    @GetMapping("/1")
    public ResponseEntity<List<ToStudentMsg>> getStudentmsg( String username){
        try {
            List<ToStudentMsg> toStudentMsgList = messageService.getStudentmsg(username);
            if(CollectionUtils.isEmpty(toStudentMsgList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(toStudentMsgList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/2")
    public ResponseEntity<List<ToTeacherMsg>> getTeachermsg(String username){
        try {
            List<ToTeacherMsg> toTeacherMsgList = messageService.getTeachermsg(username);
            return ResponseEntity.ok(toTeacherMsgList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/1/{mid}")
    public String deleteStudentmsg(@PathVariable String mid){
        return messageService.deleteStudentmsg(Integer.parseInt(mid));
    }

    @DeleteMapping("/2/{mid}")
    public String deleteTeachermsg(@PathVariable String mid){
        return messageService.deleteTeachermsg(Integer.parseInt(mid));
    }

    @PutMapping("/1")
    public String updateSPassword(@RequestBody String str){
        return studentAccountService.updateSPassword(str);
    }

    @PutMapping("/2")
    public String updateTPassword(@RequestBody String str){
        return teacherAccountService.updateTPassword(str);
    }

}
