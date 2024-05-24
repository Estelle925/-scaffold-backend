package com.yuanmeng.common.lang.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 海明
 * @since 2024/5/23
 * <p>
 *
 * </p>
 */
@Data
public class LoginParam {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "用户密码不能为空")
    private String password;
}
