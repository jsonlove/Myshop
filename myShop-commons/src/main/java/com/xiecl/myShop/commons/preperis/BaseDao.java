package com.xiecl.myShop.commons.preperis;

import com.xiecl.myShop.domain.BaseBean;
import com.xiecl.myShop.domain.TbUser;

import java.util.List;
import java.util.Map;

public interface BaseDao<T extends BaseBean> {


    /**查询全部
     * @return
     */
    public List<T> selectAll();
    /**
     * 添加
     */
    public void insertUser(T bean);
    /**
     * 修改
     */
    public void updateUser(T bean);
    /**
     * 根据ID查询
     */
    public T  selectByid(T bean);
    /**
     * 删除
     */
    public void deleteUser(T bean);

    /**
     * 分页查询
     */
    public List<T> selectLimit(Map params);
    /**
     * 查询总数
     */
    public int selectCount();
    /**
     * 分页查询符合条件
     */
    public List<T> serachLimit(Map params);
}
