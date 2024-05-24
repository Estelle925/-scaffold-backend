package com.yuanmeng.common.lang.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author chenhaiming
 */
@Data
public class IDParam {
    @NotNull(message ="参数id不能为空")
    private Long id;
}
