package com.xiecl.myShop.web.admin.service.impl;

import com.xiecl.myShop.commons.dto.BaseResult;
import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.web.admin.dao.TbUserDao;
import com.xiecl.myShop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbuserDao;
    @Override
    public List<TbUser> selectAll() {
        List<TbUser> list=tbuserDao.selectAll();
       return list;
    }

    @Override
    public BaseResult saveUser(TbUser user) {
        BaseResult result=checkUser(user);
        if(result.getStatus()==200) {
            if(null == user.getId()){
                user.setCreated(new Date());
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                user.setUpdated(new Date());
                tbuserDao.insertUser(user);
            }
            else{
                tbuserDao.updateUser(user);
            }
        }
        return result;
    }

    @Override
    public void updateUser(TbUser user) {
        tbuserDao.updateUser(user);
    }

    @Override
    public TbUser selectUserByid(TbUser user) {
        TbUser tbUser=tbuserDao.selectUserByid(user);
        return tbUser;
    }

    @Override
    public void deleteUser(TbUser user) {
        tbuserDao.deleteUser(user);
    }

    @Override
    public TbUser selectUserByNameAndPwd(TbUser user) {
        TbUser tbUser=tbuserDao.selectUserByNameAndPwd(user);
        if(null!=tbUser&&tbUser.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))){
            return tbUser;
        }else{
            return null;
        }

    }
    public BaseResult checkUser(TbUser user){
        if(StringUtils.isBlank(user.getEmail())){
            return BaseResult.fail("邮箱不能为空");
        }
        else if(StringUtils.isBlank(user.getPassword())){
            return BaseResult.fail("密码不能为空");
        }
        else if(StringUtils.isBlank(user.getUsername())){
            return BaseResult.fail("姓名不能为空");
        }
        else if(StringUtils.isBlank(user.getPhone())){
            return BaseResult.fail("手机号不能为空");
        }
        return BaseResult.success();
    }

    public Map<String,Object> gotoPage(int start,int length){
        Map<String,Integer> param=new HashMap();
        Map<String,Object> returnparam=new HashMap();
        param.put("start",start);
        param.put("length",length);
        List<TbUser> tbUsers = tbuserDao.selectLimit(param);
        int count = tbuserDao.selectCount();
        returnparam.put("data",tbUsers);
       returnparam.put("recordsTotal",count);
       returnparam.put("recordsFiltered",count);
        return returnparam;
    }
}
