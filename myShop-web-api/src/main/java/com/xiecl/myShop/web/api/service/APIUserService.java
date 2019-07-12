package com.xiecl.myShop.web.api.service;

import com.xiecl.myShop.domain.TbUser;

public interface APIUserService {
    public TbUser login(TbUser user);
    public boolean register(TbUser user);
    public boolean selectByPhoneOrNameOrEmail(String phone);
}
