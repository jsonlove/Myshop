package com.xiecl.myShop.web.admin.dao;

import com.xiecl.myShop.commons.preperis.BaseDao;
import com.xiecl.myShop.domain.Content;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDao extends BaseDao<Content> {

    /**根据ID查询内容
     * @param countid
     * @return
     */
    public Content selectByid(@Param("countid") String countid);
}
