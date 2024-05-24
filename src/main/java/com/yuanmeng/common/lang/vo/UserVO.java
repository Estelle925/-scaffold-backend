package com.yuanmeng.common.lang.vo;

import lombok.Data;

/**
 * @author 海明
 * @since 2024/5/23
 * <p>
 *
 * </p>
 */
@Data
public class UserVO {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;
    /**
     * 用户类型
     */
    private String userType;
}
