package com.yuanmeng.common.lang.vo;

import com.yuanmeng.common.lang.enums.ResultCode;
import lombok.Data;

/**
 * 通用结果集类
 *
 * @param <T> 泛型
 * @author chenhaiming
 */
@Data
public class Result<T> {

    /**
     * 操作状态码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 操作是否成功
     */
    private boolean success;

    /**
     * 数据库受影响行数
     */
    private Long space;

    /**
     * 操作结果对象
     */
    private T data;

    /**
     * 返回操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> ok() {
        return new Result<E>()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .success(true).space(null).data(null);
    }

    /**
     * 返回操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> ok(E data) {
        return new Result<E>()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .success(true).space(null).data(data);
    }

    /**
     * 返回操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> ok(ResultCode resultCode) {
        return new Result<E>()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .success(true).space(null).data(null);
    }


    /**
     * 返回操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> ok(ResultCode resultCode, Long space) {
        return new Result<E>()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .success(true).space(null).data(null);
    }

    /**
     * 返回操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> ok(ResultCode resultCode, E data) {
        return new Result<E>()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .success(true).space(null).data(data);
    }

    /**
     * 返回操作失败实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> error() {
        return new Result<E>()
                .code(ResultCode.ERROR.getCode())
                .message(ResultCode.ERROR.getMessage())
                .success(false).space(null).data(null);
    }


    /**
     * 返回操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> error(ResultCode resultCode) {
        return new Result<E>()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .success(false).space(null).data(null);
    }

    /**
     * 返回添加操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> appendOk() {
        return new Result<E>()
                .code(ResultCode.APPEND_SUCCESS.getCode())
                .message(ResultCode.APPEND_SUCCESS.getMessage())
                .success(true).space(null).data(null);
    }

    /**
     * 返回添加操作失败实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> appendError() {
        return new Result<E>()
                .code(ResultCode.APPEND_ERROR.getCode())
                .message(ResultCode.APPEND_ERROR.getMessage())
                .success(false).space(null).data(null);
    }

    /**
     * 返回编辑操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> modifyOk() {
        return new Result<E>()
                .code(ResultCode.MODIFY_SUCCESS.getCode())
                .message(ResultCode.MODIFY_SUCCESS.getMessage())
                .success(true).space(null).data(null);
    }

    /**
     * 返回编辑操作失败实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> modifyError() {
        return new Result<E>()
                .code(ResultCode.MODIFY_ERROR.getCode())
                .message(ResultCode.MODIFY_ERROR.getMessage())
                .success(false).space(null).data(null);
    }

    /**
     * 返回移除操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> removeOk() {
        return new Result<E>()
                .code(ResultCode.REMOVE_SUCCESS.getCode())
                .message(ResultCode.REMOVE_SUCCESS.getMessage())
                .success(true).space(null).data(null);
    }

    /**
     * 返回移除操作失败实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> removeError() {
        return new Result<E>()
                .code(ResultCode.REMOVE_ERROR.getCode())
                .message(ResultCode.REMOVE_ERROR.getMessage())
                .success(false).space(null).data(null);
    }

    /**
     * 返回查询操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> searchOk(E data) {
        return new Result<E>()
                .code(ResultCode.SEARCH_SUCCESS.getCode())
                .message(ResultCode.SEARCH_SUCCESS.getMessage())
                .success(true).space(null).data(data);
    }

    /**
     * 返回查询操作失败实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> searchError() {
        return new Result<E>()
                .code(ResultCode.SEARCH_ERROR.getCode())
                .message(ResultCode.SEARCH_ERROR.getMessage())
                .success(false).space(null).data(null);
    }

    /**
     * 返回上传操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> uploadOk() {
        return new Result<E>()
                .code(ResultCode.UPLOAD_SUCCESS.getCode())
                .message(ResultCode.UPLOAD_SUCCESS.getMessage())
                .success(true).space(null).data(null);
    }

    /**
     * 返回上传操作失败实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> uploadError() {

        return new Result<E>()
                .code(ResultCode.UPLOAD_ERROR.getCode())
                .message(ResultCode.UPLOAD_ERROR.getMessage())
                .success(false).space(null).data(null);
    }

    /**
     * 返回下载操作成功实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> downloadOk() {

        return new Result<E>()
                .code(ResultCode.DOWNLOAD_SUCCESS.getCode())
                .message(ResultCode.DOWNLOAD_SUCCESS.getMessage())
                .success(true).space(null).data(null);
    }

    /**
     * 返回下载操作失败实例
     *
     * @return 通用结果集对象
     */
    public static <E> Result<E> downloadError() {
        return new Result<E>()
                .code(ResultCode.DOWNLOAD_ERROR.getCode())
                .message(ResultCode.DOWNLOAD_ERROR.getMessage())
                .success(false).space(null).data(null);
    }

    /**
     * 返回操作发生异常的实例
     *
     * @param resultCode 状态码
     * @return 通用结果集对象
     */
    public static <E> Result<E> exception(ResultCode resultCode) {
        return new Result<E>()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .success(false).space(null).data(null);
    }

    public static <E> Result<E> error(Integer code, String s) {
        return new Result<E>()
                .code(code)
                .message(s)
                .success(false).space(null).data(null);
    }

    /**
     * 设置操作状态码
     *
     * @param code 操作状态码
     * @return 通用结果集对象
     */
    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }


    /**
     * 设置操作是否成功
     *
     * @param success 操作是否成功
     * @return 通用结果集对象
     */
    public Result<T> success(boolean success) {
        this.success = success;
        return this;
    }


    /**
     * 设置操作提示消息
     *
     * @param message 操作提示消息
     * @return 通用结果集对象
     */
    public Result<T> message(String message) {
        this.msg = message;
        return this;
    }


    /**
     * 设置操作结果对象
     *
     * @param data 操作结果对象
     * @return 通用结果集对象
     */
    public Result<T> data(T data) {
        this.data = data;
        return this;
    }


    /**
     * 设置操作数据库受影响行数
     *
     * @param space 操作数据库受影响行数
     * @return 通用结果集对象
     */
    public Result<T> space(Long space) {
        this.space = space;
        return this;
    }
}
