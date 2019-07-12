package com.xiecl.myShop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/rf")
    public String rf(){
        return "rf/lunbo";
    }
    @RequestMapping("/rf2")
    public String rf2(){
        return "rf/lunbo2";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
