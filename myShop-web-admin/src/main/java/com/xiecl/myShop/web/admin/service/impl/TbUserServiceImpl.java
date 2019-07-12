package com.xiecl.myShop.web.admin.service.impl;

import com.xiecl.myShop.commons.dto.UserPage;
import com.xiecl.myShop.web.admin.abstracts.BaseServiceImpl;
import com.xiecl.myShop.commons.util.DateUtil;
import com.xiecl.myShop.domain.BaseBean;
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
public class TbUserServiceImpl extends BaseServiceImpl<TbUser,TbUserDao> implements TbUserService {
    @Autowired
    private TbUserDao tbuserDao;

    @Override
    public void saveUser(TbUser user) {
            if(StringUtils.isBlank(user.getId())){
                user.setCreated(DateUtil.dateToStrFormat(new Date()));
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                user.setUpdated(DateUtil.dateToStrFormat(new Date()));
                tbuserDao.insertUser(user);
            }
            else{
                user.setUpdated(DateUtil.dateToStrFormat(new Date()));
                tbuserDao.updateUser(user);
            }
    }

    @Override
    public TbUser selectUserByid(TbUser user) {
        BaseBean baseBean = tbuserDao.selectByid(user);
        return (TbUser)baseBean;
    }

    @Override
    public void deleteUser(TbUser user) {
        tbuserDao.deleteUser(user);
    }

    @Override
    public TbUser selectUserByEmailandPassword(TbUser user) {
        TbUser tbUser=tbuserDao.selectUserByEmaill(user);
        if(null!=tbUser&&tbUser.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))){
            return tbUser;
        }else{
            return null;
        }

    }

    public UserPage gotoPage(int start, int length){
        Map<String,Integer> param=new HashMap();
       UserPage page=new UserPage();
        param.put("start",start);
        param.put("length",length);
        List<TbUser> tbUsers = tbuserDao.selectLimit(param);
        int count = tbuserDao.selectCount();
        page.setData(tbUsers);
        page.setRecordsTotal(count);
        page.setRecordsFiltered(tbUsers.size());
        return page;
    }

    public UserPage serachgopage(int start, int length,String serachValue){
        Map<String,Object> param=new HashMap();
        UserPage page=new UserPage();
        param.put("start",start);
        param.put("length",length);
        param.put("serachValue",serachValue);
        List<TbUser> tbUsers = tbuserDao.serachLimit(param);
        int count = tbuserDao.selectCount();
        page.setData(tbUsers);
        page.setRecordsTotal(count);
        page.setRecordsFiltered(tbUsers.size());
        return page;
    }
}
