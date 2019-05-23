package com.xiecl.myShop.web.admin.service.impl;

import com.xiecl.myShop.commons.dto.ContentPage;
import com.xiecl.myShop.commons.dto.ContentResult;
import com.xiecl.myShop.commons.dto.UserPage;
import com.xiecl.myShop.commons.util.DateUtil;
import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.domain.ContentCategory;
import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.web.admin.dao.ContentCategoryDao;
import com.xiecl.myShop.web.admin.dao.ContentDao;
import com.xiecl.myShop.web.admin.service.ContentCategoryService;
import com.xiecl.myShop.web.admin.service.ContentService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao dao;
    @Autowired
    private ContentCategoryDao categorydao;
    public ContentPage gotoPage(int start, int length){
        Map<String,Integer> param=new HashMap();
        ContentPage page=new ContentPage();
        param.put("start",start);
        param.put("length",length);
        List<Content> contents = dao.selectCotentLimit(param);
        int count = dao.selectCount();
        page.setData(contents);
        page.setRecordsTotal(count);
        page.setRecordsFiltered(contents.size());
        return page;
    }

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

    public ContentResult selectByid(String countid){
        Content content = dao.selectByid(countid);
        ContentCategory contentCategory = categorydao.selectByid(content.getCategoryid());
        ContentResult result=new ContentResult();
        result.setCategory(contentCategory);
        result.setContent(content);
        return result;
    }
}
