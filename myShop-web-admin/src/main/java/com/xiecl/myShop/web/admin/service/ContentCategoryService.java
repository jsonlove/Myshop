package com.xiecl.myShop.web.admin.service;

import com.xiecl.myShop.domain.ContentCategory;

import java.util.List;
public interface ContentCategoryService {
    public List<ContentCategory> selectContentCatogoryList();
    public List<ContentCategory> selectContentCatogoryByid(String parentid);
}
