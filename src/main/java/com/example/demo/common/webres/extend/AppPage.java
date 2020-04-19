package com.example.demo.common.webres.extend;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AppPage<T> {

    /**
     * 请求标识字段
     */
    private String requestId;

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 每页多少条
     */
    private Integer pageSize = 10;

    /**
     * 总共多少页
     */
    private Integer pageTotal = 0;

    /**
     * 当前页列表
     */
    private List<T> list = new ArrayList<>();

    /**
     * 总共多少条
     */
    private Integer total = 0;

    public AppPage() {
    }

    /**
     * 实际查询记录的开始数
     */
    private Integer from;


    /**
     * 实际查询记录的开始数
     */
    public Integer getFirstResult() {
        this.from = (this.currentPage - 1) * pageSize;
        return this.from;
    }

    /**
     * 实际一次查询多少条
     */
    public Integer getMaxResults() {
        return pageSize;
    }

    /**
     * 更新分页显示数据
     *
     * @param list  查询的分页数据
     * @param total 总数据
     */
    public final void updatePageInfo(List<T> list, Integer total) {
        this.list = list;
        this.total = total;
        this.pageTotal = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }
}
