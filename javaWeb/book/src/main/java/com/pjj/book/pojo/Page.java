package com.pjj.book.pojo;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年08月11日 12:20
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 10;

    //当前页码数
    private Integer pageNum;
    //页码总数
    private  Integer pageNumTotal;
    //当前页显示数量
    private Integer pageSize = PAGE_SIZE;
    //总记录条数
    private Integer pageCountTotal;
    //当前页数据
    private List<T> items;
    // 分页条的请求地址
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
    }

    public Page(Integer pageNum, Integer pageNumTotal, Integer pageSize, Integer pageCountTotal, List<T> items) {
        this.pageNum = pageNum;
        this.pageNumTotal = pageNumTotal;
        this.pageSize = pageSize;
        this.pageCountTotal = pageCountTotal;
        this.items = items;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {

        this.pageNum = pageNum;
    }

    public Integer getPageNumTotal() {
        return pageNumTotal;
    }

    public void setPageNumTotal(Integer pageNumTotal) {
        this.pageNumTotal = pageNumTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCountTotal() {
        return pageCountTotal;
    }

    public void setPageCountTotal(Integer pageCountTotal) {
        this.pageCountTotal = pageCountTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageNumTotal=" + pageNumTotal +
                ", pageSize=" + pageSize +
                ", pageCountTotal=" + pageCountTotal +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
