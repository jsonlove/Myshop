package com.xiecl.myShop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/util")
public class UtilController {
    @RequestMapping("/error")
    public String errorPage(){
        return "error/500";
    }
}
