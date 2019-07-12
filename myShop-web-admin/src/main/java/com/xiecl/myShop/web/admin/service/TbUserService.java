package com.xiecl.myShop.web.admin.service;

import com.xiecl.myShop.commons.dto.UserPage;
import com.xiecl.myShop.commons.preperis.BaseService;
import com.xiecl.myShop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {

    /**登陆
     * @param user
     * @return
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
