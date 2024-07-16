package com.yuanmeng.common.config;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yuanmeng.common.lang.dao.BaseEntity;
import org.apache.ibatis.reflection.MetaObject;
import java.util.Date;
import java.util.Objects;

/**
 * @author chenhaiming
 */
public class DefaultDataBaseFieldHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();

            Date current = new Date();
            // 创建时间为空，则以当前时间为插入时间
            if (Objects.isNull(baseEntity.getCreateTime())) {
                baseEntity.setCreateTime(current);
            }
            // 更新时间为空，则以当前时间为更新时间
            if (Objects.isNull(baseEntity.getUpdateTime())) {
                baseEntity.setUpdateTime(current);
            }

            Object userId = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());

            // 当前登录用户不为空，创建人为空，则当前登录用户为创建人
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getCreatorId())) {
                baseEntity.setCreatorId(userId.toString());
            }
            // 当前登录用户不为空，更新人为空，则当前登录用户为更新人
            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getUpdaterId())) {
                baseEntity.setUpdaterId(userId.toString());
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间为空，则以当前时间为更新时间
        Object modifyTime = getFieldValByName("updateTime", metaObject);
        if (Objects.isNull(modifyTime)) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

        // 当前登录用户不为空，更新人为空，则当前登录用户为更新人
        Object modifier = getFieldValByName("updater", metaObject);

        Object userId = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());
        if (Objects.nonNull(userId) && Objects.isNull(modifier)) {
            setFieldValByName("updater", userId.toString(), metaObject);
        }
    }
}
