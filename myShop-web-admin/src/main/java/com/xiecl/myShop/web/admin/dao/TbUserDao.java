package com.xiecl.myShop.web.admin.dao;

import com.xiecl.myShop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao {
    public List<TbUser> selectAll();
    /**
     * 添加用户
     */
    public void insertUser(TbUser user);
    /**
     * 修改用户
     */
    public void updateUser(TbUser user);
    /**
     * 根据ID查询用户
     */
    public TbUser selectUserByid(TbUser user);
    /**
     * 删除用户
     */
    public void deleteUser(TbUser user);
    /**
     * 根据用户名和密码查询用户
     */
    public TbUser selectUserByNameAndPwd(TbUser user);

    public List<TbUser> selectLimit(Map params);

    public int selectCount();
}
