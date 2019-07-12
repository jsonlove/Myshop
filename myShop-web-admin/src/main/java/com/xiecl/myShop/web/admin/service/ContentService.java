package com.xiecl.myShop.web.admin.service;

import com.xiecl.myShop.commons.dto.ContentPage;
import com.xiecl.myShop.commons.dto.ContentResult;
import com.xiecl.myShop.domain.Content;

public interface ContentService {
    public ContentPage gotoPage(int start, int end);
    public ContentPage serachgopage(int start,int end,String serachValue);
    public ContentResult selectByid(String countid);
    public void addContent(Content content);
    public void UpdateContent(Content content);
}
