package com.yuanmeng.common.lang;


import com.yuanmeng.common.lang.enums.ResultCode;
import com.yuanmeng.common.lang.exception.RdosDefineException;
import com.yuanmeng.common.lang.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller模板类
 *
 * @author chenhaiming
 * @param <T> 前端返回类型
 */
public abstract class AbstractApiTemplate<T> {
    /**
     * 业务执行时间默认阀值(10秒)
     */
    public static final long THRESHOLD = 10_000L;
    protected Logger log = LoggerFactory.getLogger(getClass());

    protected AbstractApiTemplate() {

    }

    /**
     * 业务入参合法性校验
     *
     * @throws IllegalArgumentException 参数校验异常
     */
    protected abstract void checkParams() throws IllegalArgumentException;

    /**
     * 业务方法执行入口,业务异常时抛出BizException
     *
     * @return 业务执行结果信息返回
     * @throws RdosDefineException 业务执行异常
     */
    protected abstract T process() throws RdosDefineException;

    /**
     * 后置处理器
     */
    protected void afterProcess() {

    }

    /**
     * 业务处理成功回调函数
     */
    protected void onSuccess() {

    }

    /**
     * 业务处理执行异常回调
     *
     * @param e 业务执行异常
     */
    protected void onError(Throwable e) {
        if (log.isErrorEnabled()) {
            log.error("API Error while execute ", e);
        }
    }

    /**
     * 执行业务,返回统一的JSON格式(R)
     *
     * @return 业务执行返回R格式
     */
    public Result<T> execute() {
        try {
            checkParams();
        } catch (IllegalArgumentException e) {
            if (log.isInfoEnabled()) {
                log.info("param check error:", e);
            }
            return Result.error(ResultCode.INVALID_PARAMETERS.getCode(), e.getMessage());
        } catch (RdosDefineException e) {
            onError(e);
            return Result.error(e.getResultCode().getCode(), e.getErrorMessage());
        }
        long sTime = System.currentTimeMillis();
        try {
            T r = process();
            onSuccess();
            return Result.ok(r).space(System.currentTimeMillis() - sTime);
        } catch (RdosDefineException be) {
            onError(be);
            return Result.error(be.getResultCode().getCode(), be.getMessage());
        } catch (Throwable e) {
            onError(e);
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            throw new RuntimeException(e);
        } finally {
            afterProcess();
            long costTime = System.currentTimeMillis() - sTime;
            if (costTime > THRESHOLD) {
                if (log.isWarnEnabled()) {
                    log.warn("this api method execute cost too long time, please optimize it:{} ms", costTime);
                }
            }
        }
    }


}
