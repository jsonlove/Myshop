package com.xiecl.myShop.web.admin.abstracts;

import com.xiecl.myShop.commons.preperis.BaseDao;
import com.xiecl.myShop.commons.preperis.BaseService;
import com.xiecl.myShop.domain.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseServiceImpl<T extends BaseBean,D extends BaseDao<T>> implements BaseService<T> {
    @Autowired
    protected D dao;
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

}
