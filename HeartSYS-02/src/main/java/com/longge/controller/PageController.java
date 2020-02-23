package com.longge.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping("/studentPage/toChoosetPage")
    public String toChooset(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/studentPage/chooset";
    }

    @RequestMapping("/studentPage/toAskteacherPage")
    public String toAskteacher(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/studentPage/askteacher";
    }

    @RequestMapping("/studentPage/toTestPage")
    public String toTest(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/studentPage/test";
    }

    @RequestMapping("/teacherPage/toCheckstudentsPage")
    public String toCheckstudents(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/teacherPage/checkstudents";
    }

    @RequestMapping("/teacherPage/toCountPage")
    public String toCount(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/teacherPage/count";
    }

    @RequestMapping("/adminPage/toAccountPage")
    public String toAccount(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/adminPage/account";
    }

    @RequestMapping("/adminPage/toGroupPage")
    public String toGroup(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/adminPage/group";
    }

    @RequestMapping("/adminPage/toQuestionsPage")
    public String toQuestions(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/adminPage/questions";
    }

    @RequestMapping("/toMainPage")
    public String toMain(){
        return "main";
    }

    @GetMapping("/toMainPage/{id}")
    @ResponseBody
    public String toMain2(@PathVariable String id){
        return id;
    }

}

