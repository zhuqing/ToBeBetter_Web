package xyz.tobebetter.util;


import xyz.tobebetter.entity.Entity;

import java.util.UUID;

/**
 * Created by zhuqing on 2017/10/15.
 */
public class EntityUtil {

    public static <T extends Entity> T setDate(T entity) {
        entity.setCreateDate(System.currentTimeMillis());
        entity.setStatus(0);
        entity.setId(UUID.randomUUID().toString());
        reSetUpdateDate(entity);
        return entity;
    }

    public static <T extends Entity> void reSetUpdateDate(T entity) {
        entity.setUpdateDate(System.currentTimeMillis());
    }
}
