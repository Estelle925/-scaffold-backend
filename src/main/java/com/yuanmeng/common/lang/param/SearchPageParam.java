package com.yuanmeng.common.lang.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chenhaiming
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchPageParam extends PageParam {
    private String search;
}
