package com.longge.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginerror(Model model){
        model.addAttribute("error",true);
        return "login";
    }

}
