package com.xiecl.myShop.web.admin.service;

import com.xiecl.myShop.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;
import sun.security.rsa.RSASignature;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService service;
    @Test
    public void selectAll(){
        service.selectAll();
    }
    @Test
    public void insertUser(){
//        TbUser user1=new TbUser("xiecl1","123456","152436121241","75231@qq.com",new Date(),new Date());
//        user1.setPassword(user1.getPassword());
//        service.saveUser(user1);
    };
    @Test
    public void updateUser(){
//        TbUser user1=new TbUser("xiecl", DigestUtils.md5DigestAsHex("123456".getBytes()),"15243612124","7523@qq.com",new Date(),new Date());
//        service.updateUser(user1);
    };
    @Test
    public void selectUserByid(){
        TbUser users=new TbUser();
        users.setId("7");
      users=service.selectUserByid(users);
        System.out.println(users.getUsername());
    };
    @Test
    public void deleteUser(){
        TbUser user1=new TbUser();
        user1.setId("41");
        service.deleteUser(user1);
    };
    @Test
    public void selectUserByNameAndPwd(){

    };
}
