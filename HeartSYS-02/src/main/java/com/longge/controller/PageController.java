package com.longge.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping("/toChoosetPage")
    public String toChooset(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/studentPage/chooset";
    }

    @RequestMapping("/toAskteacherPage")
    public String toAskteacher(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/studentPage/askteacher";
    }

    @RequestMapping("/toTestPage")
    public String toTest(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/studentPage/test";
    }

    @RequestMapping("/toCheckstudentsPage")
    public String toCheckstudents(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/teacherPage/checkstudents";
    }

    @RequestMapping("/toCountPage")
    public String toCount(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/teacherPage/count";
    }

    @RequestMapping("/toAccountPage")
    public String toAccount(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/adminPage/account";
    }

    @RequestMapping("/toGroupPage")
    public String toGroup(HttpServletRequest req){
        String path = req.getServletContext().getContextPath();
        return path + "/adminPage/group";
    }

    @RequestMapping("/toQuestionsPage")
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

