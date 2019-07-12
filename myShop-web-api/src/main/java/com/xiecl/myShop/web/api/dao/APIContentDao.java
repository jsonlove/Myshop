package com.xiecl.myShop.web.api.dao;

import com.xiecl.myShop.commons.preperis.BaseDao;
import com.xiecl.myShop.domain.Content;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface APIContentDao extends BaseDao<Content> {
    public List<Content> selectByCategoryId(@Param("categoryid") String categoryid);
}
