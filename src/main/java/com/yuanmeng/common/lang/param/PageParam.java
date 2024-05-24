package com.yuanmeng.common.lang.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenhaiming
 */
@Data
public class PageParam implements Serializable {
    private Long current;
    private Long size;

    public PageParam() {
        this.current = 1L;
        this.size = 10L;
    }
}
