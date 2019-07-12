package com.xiecl.myShop.web.api.dao;

import com.xiecl.myShop.commons.preperis.BaseDao;
import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface APIUserDao extends BaseDao<TbUser> {
    public TbUser login(TbUser tbuser);
    public TbUser selectByphone(TbUser user);
    public TbUser selectByPhoneOrNameOrEmail(String phone);
}
