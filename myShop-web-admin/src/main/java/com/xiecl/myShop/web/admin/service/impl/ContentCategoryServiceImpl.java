package com.xiecl.myShop.web.admin.service.impl;

import com.xiecl.myShop.domain.ContentCategory;
import com.xiecl.myShop.web.admin.dao.ContentCategoryDao;
import com.xiecl.myShop.web.admin.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private ContentCategoryDao dao;
    public List<ContentCategory> selectContentCatogoryList(){
        return dao.selectContentCatogoryList();
    }
    public List<ContentCategory> selectContentCatogoryByid(String parentid){
//        Map<String,Object> param=new HashMap<>();
//        param.put("parentid",parentid);
        List<ContentCategory> contentCategories = dao.selectContentCatogoryByid(parentid);
        return contentCategories==null?new ArrayList<ContentCategory>():contentCategories;
    }
}
