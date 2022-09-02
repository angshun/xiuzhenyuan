package com.ptteng.score.home.util;

/**
 * Created by ZengTian on 2017/8/10.
 */
public class PageUtil {
    private Integer page;
    private Integer size;

    public PageUtil(Integer page, Integer size) {
        if (page == null || page < 1) {
            page = 1;
        }
        if (size == null || size <= 0) {
            size = 50;
        }
        this.page = page;
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getStart() {
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        return start;
    }

    public Integer getPage() {
        return page;
    }
}
