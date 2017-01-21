package com.comb.commons.pojo;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 * easyUI响应分页对象
 */
public class EasyUIResponsePagination<T> {
    /**
     * 总共多少条
     */
    private int total ;
    /**
     * 分页内容对象
     */
    private List<T> rows ;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
