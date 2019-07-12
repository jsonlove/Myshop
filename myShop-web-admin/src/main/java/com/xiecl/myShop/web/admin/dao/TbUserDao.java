package com.xiecl.myShop.web.admin.dao;

import com.xiecl.myShop.commons.preperis.BaseDao;
import com.xiecl.myShop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * 根据用户名和密码查询用户
     */
    public TbUser selectUserByEmaill(TbUser entity);


}
