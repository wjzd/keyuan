package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoController {

    @RequestMapping("/login")
    public String login(){

        System.out.println("1111111");
        return "fileUpload.html";
    }
}
