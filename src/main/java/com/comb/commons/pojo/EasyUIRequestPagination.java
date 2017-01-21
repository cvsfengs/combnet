package com.comb.commons.pojo;

/**
 * Created by Administrator on 2016/7/31.
 * easyUI请求分页对象
 */
public class EasyUIRequestPagination<T> {
    /**
     * 第几页
     */
    private int page ;
    /**
     * 每页显示多少条
     */
    private int rows ;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
