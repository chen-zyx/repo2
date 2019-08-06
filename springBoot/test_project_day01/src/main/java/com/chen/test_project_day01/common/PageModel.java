package com.chen.test_project_day01.common;

import java.util.List;

/**
 * 分页工具类
 */
public class PageModel<T> {
    //每页记录数
    private Integer pageSize=5;
    //当前页面
    private Integer currentPage;
    //总记录数
    private Integer total;
    //关键字
    private String keyword;
    //每页包含的记录数
    private List<T> rows;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
