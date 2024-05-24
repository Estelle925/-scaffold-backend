package com.yuanmeng.common.lang.vo;

import com.google.common.collect.Lists;
import com.yuanmeng.common.lang.param.PageParam;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author chenhaiming
 */
@Data
public class PageResult<T> implements Serializable {

    private Long current;
    private Long size;
    private Long total;
    private Collection<T> records;

    public PageResult() {
    }

    public PageResult(Long current, Long size, Long total, Collection<T> records) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.records = records;
    }

    public static <T> PageResult<T> empty(PageParam param) {
        return new PageResult<>(1L, param.getSize(), 0L, Lists.newArrayList());
    }

}
