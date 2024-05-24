package com.yuanmeng.common.lang.exception;


import com.yuanmeng.common.lang.enums.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * @author chenhaiming
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RdosDefineException extends RuntimeException {


    private String errorMessage;

    private ResultCode resultCode;

    public RdosDefineException() {
    }

    public RdosDefineException(Throwable cause) {
        super(cause);
        this.resultCode = ResultCode.SERVER_INTERNAL_ERROR;
    }

    public RdosDefineException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.resultCode = ResultCode.SERVER_INTERNAL_ERROR;
    }

    public RdosDefineException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
        this.resultCode = ResultCode.SERVER_INTERNAL_ERROR;
    }

    public RdosDefineException(ResultCode resultCode) {
        super(buildErrorInfo(resultCode, resultCode.getMessage()));
        this.resultCode = resultCode;
        setErrorMessage("");
    }

    public RdosDefineException(String message, ResultCode resultCode) {
        super(buildErrorInfo(resultCode, message));
        this.resultCode = resultCode;
        setErrorMessage(message);
    }

    public RdosDefineException(String message, ResultCode resultCode, String url) {
        super(buildErrorInfo(resultCode, message, url));
        this.resultCode = resultCode;
        setErrorMessage(message);
    }

    public RdosDefineException(ResultCode resultCode, Throwable cause) {
        super(buildErrorInfo(resultCode, resultCode.getMessage()), cause);
        this.resultCode = resultCode;
    }

    public RdosDefineException(String message, ResultCode resultCode, Throwable cause) {
        super(buildErrorInfo(resultCode, message), cause);
        this.resultCode = resultCode;
        setErrorMessage(message);
    }

    private void setErrorMessage(String extMsg) {
        if (StringUtils.isEmpty(extMsg)) {
            this.errorMessage = resultCode.getMessage();
        } else {
            this.errorMessage = resultCode.getMessage() + "-" + extMsg;
        }
    }

    private static String buildErrorInfo(ResultCode resultCode, String errorMessage) {
        return errorMessage;
    }

    private static String buildErrorInfo(ResultCode resultCode, String errorMessage, String url) {
        return errorMessage + url;
    }
}
