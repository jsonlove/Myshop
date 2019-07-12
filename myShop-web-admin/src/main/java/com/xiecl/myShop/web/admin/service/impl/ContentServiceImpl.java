package com.xiecl.myShop.web.admin.service.impl;

import com.xiecl.myShop.commons.dto.ContentPage;
import com.xiecl.myShop.commons.dto.ContentResult;
import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.domain.ContentCategory;
import com.xiecl.myShop.web.admin.dao.ContentCategoryDao;
import com.xiecl.myShop.web.admin.dao.ContentDao;
import com.xiecl.myShop.web.admin.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao dao;
    @Autowired
    private ContentCategoryDao categorydao;
    @Override
    public ContentPage gotoPage(int start, int length){
        Map<String,Integer> param=new HashMap();
        ContentPage page=new ContentPage();
        param.put("start",start);
        param.put("length",length);
        List<Content> contents = dao.selectLimit(param);
        int count = dao.selectCount();
        page.setData(contents);
        page.setRecordsTotal(count);
        page.setRecordsFiltered(contents.size());
        return page;
    }
    @Override
    public ContentPage serachgopage(int start, int length,String serachValue){
        Map<String,Object> param=new HashMap();
        ContentPage page=new ContentPage();
        param.put("start",start);
        param.put("length",length);
        param.put("serachValue",serachValue);
        List<Content> contents = dao.serachLimit(param);
        int count = dao.selectCount();
        page.setData(contents);
        page.setRecordsTotal(count);
        page.setRecordsFiltered(contents.size());
        return page;
    }
    @Override
    public ContentResult selectByid(String countid){
        Content content = dao.selectByid(countid);
        ContentCategory contentCategory = categorydao.selectByid(content.getCategoryid());
        ContentResult result=new ContentResult();
        result.setCategory(contentCategory);
        result.setContent(content);
        return result;
    }
    @Override
    public void addContent(Content content){
        content.setCreated("2019-04-07");
        content.setUpdated("2019-04-05");
        dao.insertUser(content);
    };
    @Override
    public void UpdateContent(Content content) {
        dao.updateUser(content);
    }


}
