package com.xiecl.myShop.commons.preperis;

import com.xiecl.myShop.domain.BaseBean;

import java.util.List;

public interface BaseService<T extends BaseBean> {
    /**
     * 查询全部
     */
    public List<T> selectAll();
    /**
     * 添加
     */
    public void saveUser(T bean);

    /**
     * 根据ID查询
     */
    public T selectUserByid(T bean);
    /**
     * 删除
     */
    public void deleteUser(T bean);
}
