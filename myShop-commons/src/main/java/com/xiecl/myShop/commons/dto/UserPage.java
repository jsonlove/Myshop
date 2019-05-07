package com.xiecl.myShop.commons.dto;

import com.xiecl.myShop.domain.TbUser;

import java.util.List;

public class UserPage {

    /**
     * 分页数据
     */
    private List<TbUser> data;
    /**
     * 数据库里总共记录数
     */
    private int recordsTotal;
    /**
     * 过滤后的记录数
     */
    private int recordsFiltered;
    /**
     * 第几页
     */
    private int draw;
    /**
     * 错误信息
     */
    private String error;

    public List<TbUser> getData() {
        return data;
    }

    public void setData(List<TbUser> data) {
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
