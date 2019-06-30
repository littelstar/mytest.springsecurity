package com.lpp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal!=null){
            if(principal instanceof UserDetails){
                UserDetails user= (UserDetails) principal;
                String username = user.getUsername();
                model.addAttribute("user",username);
            }
        }
        return "index";
    }

    @RequestMapping("/")
    public String indexHome(){
        return "index";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
    @RequestMapping("/userlogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/imageCode")
    public String imageCode(){
        return "imageCode";
    }
}
