package com.xiecl.myShop.web.api.service;

import com.xiecl.myShop.domain.Content;

import java.util.List;

public interface APIContentService {
    public List<Content> selectByCategoryId(String categoryid);
}
