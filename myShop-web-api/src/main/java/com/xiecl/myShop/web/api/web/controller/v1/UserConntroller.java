package com.xiecl.myShop.web.api.web.controller.v1;

import com.xiecl.myShop.commons.dto.BaseResult;
import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.web.api.service.APIUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.path.v1}/users")
public class UserConntroller {
    private Logger log= LoggerFactory.getLogger(UserConntroller.class);
    @Autowired
    private APIUserService service;

    @RequestMapping("login")
    public BaseResult login(TbUser tbUser){
        log.info("用户"+tbUser.getUsername()+"尝试登录");
        TbUser tbUser1 = service.login(tbUser);
        BaseResult result=null;
        if(tbUser1 != null){
            result=BaseResult.success("登录成功",tbUser1);
        }
        else{
            result=BaseResult.fail("用户名或密码错误");
        }
        return result;
    }

    @RequestMapping("register")
    public BaseResult register(TbUser tbUser){
        TbUser checkuser=null;
        String [] names={tbUser.getUsername(),tbUser.getEmail(),tbUser.getPhone()};
        for (String name:
             names) {
            if (service.selectByPhoneOrNameOrEmail(name)){
                return BaseResult.fail("账户名或邮箱手机已被使用");
            }
        }

        log.info("用户"+tbUser.getUsername()+"进行注册");
        Boolean isregister = service.register(tbUser);
        BaseResult result=null;
        if(isregister){
            result=BaseResult.success("注册成功");
        }
        else{
            result=BaseResult.fail("注册失败");
        }
        return result;
    }

}