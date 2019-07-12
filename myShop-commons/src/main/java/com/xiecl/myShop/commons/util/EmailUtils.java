package com.xiecl.myShop.commons.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailUtils {
    @Autowired
    private  Email email;
    // 注释属性通过配置文件注入
    public  void sendSimpleEmail(String to,String msg,String title) {
       // SimpleEmail email = new SimpleEmail();
        //email.setHostName("smtp.qq.com"); // 设置发送端服务器
        //email.setSmtpPort(465);
       // email.setAuthentication("752389628@qq.com", "nimjgmbsqotfbead"); // 用户名和密码
        email.setCharset("UTF-8"); // 设置字符集
        //email.setSSL(true); // gmail邮箱必须设置为true
        try {
          //  email.setFrom("752389628@qq.com", "发件人"); // 发件人
            email.addTo(to, "第一个收件人"); // 收件人1
        // email.addTo("test@qq.com", "哈哈"); // 收件人2
        // email.addCc("test@gmail.com", "test"); // 抄送
        // email.addBcc("test@sina.com", "test"); // 密送
            email.setSubject(title); // 主题
            email.setMsg(msg); // 发送内容
            email.send();
            System.out.println("success!");
        } catch (EmailException e) {
            System.out.println("failure!");
            e.printStackTrace();
        }
    }
}
