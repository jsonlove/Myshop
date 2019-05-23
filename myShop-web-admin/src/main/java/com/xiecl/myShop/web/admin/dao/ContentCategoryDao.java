package com.xiecl.myShop.web.admin.dao;

import com.xiecl.myShop.domain.ContentCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
public interface ContentCategoryDao {
    List<ContentCategory> selectContentCatogoryList();
    @Select("select content.id,\n" +
            "            content.parent_id as parentid,\n" +
            "            content.name,\n" +
            "            content.status,\n" +
            "            content.sort_order as sortorder,\n" +
            "            content.is_parent as isparent,\n" +
            "            content.created,\n" +
            "            content.updated  from  tb_content_category as content where content.parent_id = #{parentid} ")
    public List<ContentCategory> selectContentCatogoryByid(@Param("parentid") String parentid);
    ContentCategory selectByid(@Param("id") String id);
}
