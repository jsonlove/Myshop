package com.xiecl.myShop.web.api.service.impl;

import com.xiecl.myShop.commons.util.DateUtil;
import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.web.api.dao.APIContentDao;
import com.xiecl.myShop.web.api.dao.APIUserDao;
import com.xiecl.myShop.web.api.service.APIContentService;
import com.xiecl.myShop.web.api.service.APIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class APIUserServiceImpl implements APIUserService {
    @Autowired
    private APIUserDao dao;


    @Override
    public TbUser login(TbUser user){
        TbUser tbUser = dao.login(user);
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if(null != tbUser && tbUser.getPassword().equals(password)){
            return  tbUser;
        }

        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean register(TbUser user) {
        user.setCreated(DateUtil.dateToStrFormat(new Date()));
        user.setUpdated(DateUtil.dateToStrFormat(new Date()));
        //密码加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        dao.insertUser(user);
        TbUser user1 = dao.selectByphone(user);
        if(null != user1){
            return  true;
        }
        return false;
    }
    @Override
    public boolean selectByPhoneOrNameOrEmail(String phone){
        TbUser user = dao.selectByPhoneOrNameOrEmail(phone);
        if(user != null){
            return true;
        }
        return false;
    }
}
