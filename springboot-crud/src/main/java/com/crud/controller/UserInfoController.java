package com.crud.controller;

import com.crud.domain.UserInfo;
import com.crud.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService service;

    @GetMapping
    public List<UserInfo> findAll()
    {
        return service.findAll();
    }

    @PostMapping
    public UserInfo create(@RequestBody UserInfo userInfo){
        service.create(userInfo);
        return userInfo;
    }

    @DeleteMapping
    public void delete(String id){
        service.delete(id);
    }


}
