package com.xiecl.myShop.web.admin.dao;

import com.xiecl.myShop.domain.Content;
import com.xiecl.myShop.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ContentDao {

    /**分页查询所有内容
     * @param map
     * @return
     */
    public List<Content> selectCotentLimit(Map map);
    /**
     * 分页查询符合条件用户
     */
    public List<Content> serachLimit(Map params);
    public int selectCount();
    public Content selectByid(@Param("countid") String countid);
}
