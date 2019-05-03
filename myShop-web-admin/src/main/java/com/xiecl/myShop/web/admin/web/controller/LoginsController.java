package com.xiecl.myShop.web.admin.web.controller;

import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xiecl.myShop.commons.constans.ConstansUtil;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginsController {


    @Autowired
    private TbUserService userService;


    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String loginGet(){
        return "login";
    }


    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String loginPost(String email, String password, String isRemember, HttpServletRequest request, Model model){
        TbUser user=new TbUser();
        user.setEmail(email);
        user.setPassword(password);
        user = userService.selectUserByNameAndPwd(user);
        if(user!=null){
            request.getSession().setAttribute(ConstansUtil.SESSION_USER,user);
            return "redirect:/home";
        }
        else{
            model.addAttribute("message","密码或用户名错误");
            return "login";
        }

    }
    @RequestMapping("/logout")
    public String loginOut(HttpServletRequest request){
        if(request.getSession().getAttribute(ConstansUtil.SESSION_USER)!=null){
            request.getSession().removeAttribute(ConstansUtil.SESSION_USER);
            System.out.println("======================");
        }
        return "/login";
    }
}
