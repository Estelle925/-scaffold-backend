package com.yuanmeng.common.lang.enums;

import lombok.Getter;

/**
 * 结果集状态码（枚举类）
 *
 * @author Bing
 */
@Getter
public enum ResultCode {
    /**
     * 0-操作成功 200-操作成功 201-添加操作成功 202-编辑操作成功 203-移除操作成功 204-修改密码成功 205-上传操作成功 206-下载操作成功 207-用户登录成功 208-退出系统成功 209-修改密码成功
     * 800-操作失败 801-添加操作失败 802-编辑操作失败 803-移除操作失败 804-修改密码失败 805-上传操作失败
     * 900-系统异常 901-系统错误 902-系统错误 903-系统错误 904-系统错误 905-系统错误 906-系统错误 907-系统错误 908-系统错误
     * 909-系统错误 910-系统错误 911-系统错误 912-系统错误 913-系统错误 914-系统错误 915-系统错误 916-系统错误 917-系统错误 918-系统
     */
    SUCCESS_DEFAULT(0, "操作成功"),
    SUCCESS(200, "操作成功"),
    APPEND_SUCCESS(201, "添加操作成功"),
    MODIFY_SUCCESS(202, "编辑操作成功"),
    REMOVE_SUCCESS(203, "移除操作成功"),
    SEARCH_SUCCESS(200, "查询信息操作成功"),
    UPLOAD_SUCCESS(205, "上传操作成功"),
    DOWNLOAD_SUCCESS(206, "下载操作成功"),
    LOGIN_SUCCESS(207, "用户登录成功"),
    LOGOUT_SUCCESS(208, "退出系统成功"),
    MODIFY_PASSWORD_SUCCESS(209, "修改密码成功"),

    ERROR(800, "操作失败"),
    APPEND_ERROR(801, "添加操作失败"),
    MODIFY_ERROR(802, "编辑操作失败"),
    REMOVE_ERROR(803, "移除操作失败"),
    SEARCH_ERROR(800, "查询信息操作失败"),
    UPLOAD_ERROR(805, "上传操作失败"),
    DOWNLOAD_ERROR(806, "下载操作失败"),
    LOGIN_ERROR(807, "用户名不存在或密码错误"),
    USER_LOCK(808, "用户被锁定"),
    LOGIN_FORBIDDEN(809, "非法的用户,登录请求被拒绝"),
    InOperation(800, "有待完成的操作"),

    BAD_REQUEST_ERROR(400, "错误请求，因发送的请求语法错误，服务器无法正常读取"),
    INVALID_PARAMETERS(400, "非法请求参数"),
    FORBIDDEN_ERROR(403, "客户端没有权利访问所请求内容，服务器拒绝本次请求"),
    NOT_FOUND_ERROR(404, "服务器找不到所请求的资源"),
    METHOD_NOT_ALLOWED_ERROR(405, "客户端没有权利访问所请求内容，服务器拒绝本次请求"),
    SERVER_INTERNAL_ERROR(500, "操作失败，服务器内部发生错误(过滤)"),
    ;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 提示消息
     */
    private final String message;
}
