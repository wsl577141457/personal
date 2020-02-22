package com.longge.controller;

import com.longge.pojo.TeacherAccount;
import com.longge.pojo.TeacherGroup;
import com.longge.service.ITeacherGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacherGroup")
public class TeacherGController {
    @Autowired
    private ITeacherGService service;

    @GetMapping
    public ResponseEntity<List<TeacherGroup>> queryAll(){
        try {
            List<TeacherGroup> teacherGroupList = service.queryAll();
            if(CollectionUtils.isEmpty(teacherGroupList)){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(teacherGroupList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping
    public String saveTeacherGroup(@RequestBody String teacherGroupStr){
        try {
            TeacherGroup teacherGroup = service.saveTeacherGroup(teacherGroupStr);
            return "插入成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "没有该老师";
    }

    @DeleteMapping("/{gid}")
    public String deleteTeacherGroup(@PathVariable String gid){
        try {
            service.deleteTeacherGroup(gid);
            return "插入成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "插入失败";
    }

    @PutMapping
    public String updateTeacherGroup(@RequestBody String teacherGroupStr){
        try {
            service.updateTeacherGroup(teacherGroupStr);
            return "修改成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "修改失败";
    }
}
