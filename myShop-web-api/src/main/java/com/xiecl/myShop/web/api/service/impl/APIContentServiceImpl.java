package com.xiecl.myShop.web.api.service.impl;

import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.web.api.dao.APIContentDao;
import com.xiecl.myShop.web.api.service.APIContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class APIContentServiceImpl implements APIContentService {
    @Autowired
    private APIContentDao dao;


    @Override
    public List<Content> selectByCategoryId(String categoryid){
        List<Content> contents = dao.selectByCategoryId(categoryid);
        return contents;
    }
}
