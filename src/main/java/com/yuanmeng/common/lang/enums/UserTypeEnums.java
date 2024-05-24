package com.yuanmeng.common.lang.enums;

import lombok.Getter;

/**
 * @author 海明
 * @since 2024/5/23
 * <p>
 *
 * </p>
 */
@Getter
public enum UserTypeEnums {
    /**
     * 1：超级管理员；2：管理员；3：普通用户
     */
    SUPER_ADMIN(1, "超级管理员"),
    ADMIN(2, "管理员"),
    USER(3, "普通用户");

    private final int code;
    private final String desc;

    UserTypeEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
