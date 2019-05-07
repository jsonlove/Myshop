package com.xiecl.myShop.web.admin.service;

import com.xiecl.myShop.commons.dto.BaseResult;
import com.xiecl.myShop.commons.dto.UserPage;
import com.xiecl.myShop.domain.TbUser;

import java.util.List;
import java.util.Map;

public interface TbUserService {

    /**
     * 查询全部用户
     */
    public List<TbUser> selectAll();
    /**
     * 添加用户
     */
    public BaseResult saveUser(TbUser user);
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
    public TbUser selectUserByEmailandPassword(TbUser user);

    /**
     * 取得分页信息
     */
    public UserPage gotoPage(int start, int length);
    /**
     * 取得搜索分页信息
     */
    public UserPage serachgopage(int start, int length,String serachValue);
}
