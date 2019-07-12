package com.xiecl.myShop.ui.conntroller;

import com.google.code.kaptcha.Constants;
import com.xiecl.myShop.commons.constans.ConstansUtil;
import com.xiecl.myShop.commons.dto.BaseResult;
import com.xiecl.myShop.commons.util.EmailUtils;
import com.xiecl.myShop.commons.util.MapperUtils;
import com.xiecl.myShop.commons.util.MyHttpClients;
import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.ui.api.APIConstans;
import com.xiecl.myShop.ui.api.ConstansUi;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("members")
public class LoginConntroller {
    @Autowired
    private EmailUtils emailUtils;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "loginout",method = RequestMethod.GET)
    public String loginout(HttpServletRequest request)
    {
        request.getSession().removeAttribute(ConstansUi.CACHE_USER_KEY);
        return "index";

    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(TbUser tbUser, HttpServletRequest request, Model model){
        List<BasicNameValuePair> list=new ArrayList<>();
        list.add(new BasicNameValuePair("username",tbUser.getUsername()));
        list.add(new BasicNameValuePair("password",tbUser.getPassword()));
        String test=request.getParameter("testcode");
        String verification = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(!StringUtils.equals(test,verification)){

            model.addAttribute("loginresult", BaseResult.fail("验证码错误"));
            return "login";
        }

        String result = MyHttpClients.doPost(APIConstans.API_USERS_LOGIN, list.toArray(new BasicNameValuePair[list.size()]));
        if(null == result && result.length()==0){
            model.addAttribute("loginresult", BaseResult.fail("用户名或密码错误"));
            return "login";
        }
        TbUser user=null;
        try {
            user= MapperUtils.json2pojoByTree(result, "data", TbUser.class);
        } catch (Exception e) {
            e.printStackTrace();

        }

        if(user != null){
            request.getSession().setAttribute(ConstansUi.CACHE_USER_KEY,user);
            emailUtils.sendSimpleEmail("xiecl@uxunchina.com",String.format("用户【%s】登录成功",user.getUsername()),"登陆成功");
            return "redirect:/index";

        }else {
            model.addAttribute("loginresult", BaseResult.fail("用户名或密码错误"));
            return "login";
        }

    }


    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(TbUser tbUser, HttpServletRequest request, Model model){
        List<BasicNameValuePair> list=new ArrayList<>();
        list.add(new BasicNameValuePair("username",tbUser.getUsername()));
        list.add(new BasicNameValuePair("password",tbUser.getPassword()));
        list.add(new BasicNameValuePair("email",tbUser.getEmail()));
        list.add(new BasicNameValuePair("phone",tbUser.getPhone()));

        String result = MyHttpClients.doPost("http://127.0.0.1:8081/myshop-api/api/v1/users/register",
                list.toArray(new BasicNameValuePair[list.size()]));
        if(null == result && result.length()==0){
            model.addAttribute("registerresult", BaseResult.fail("网络错误"));
            return "register";
        }
        BaseResult baseresult=null;
        try {
             baseresult= MapperUtils.json2pojo(result, BaseResult.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(baseresult == null || baseresult.getStatus()== ConstansUtil.RESULT_CODE_ERROR){
            model.addAttribute("registerresult", BaseResult.fail("注册失败，请检查参数"));
            return "register";
        }else{
            model.addAttribute("loginresult", BaseResult.fail("注册成功"));
            return "login";
        }
    }


}
